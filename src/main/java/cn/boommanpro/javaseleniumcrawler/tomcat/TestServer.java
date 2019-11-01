package cn.boommanpro.javaseleniumcrawler.tomcat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
/**
 * @author wangqimeng
 * @date 2019/11/1 14:38
 */



public class TestServer {

    //获取resources路径
    public static String WEB_ROOT = TestServer.class.getClassLoader().
            getResource("./").getPath();
    //请求的内容，域名后的地址
    private static String url = "";
    //定义一个静态类型的MAP，存储服务conf.properties中的配置信息
    private static Map<String, String> map = new HashMap<String, String>();

    static {
        //服务器启动之前将配置参数中的信息加载到MAP中
        //创建一个Properties对象
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(WEB_ROOT + "conf.properties"));
            //将配置文件中的数据读取到Map中
            Set set = prop.keySet();
            Iterator iter = set.iterator();
            while (iter.hasNext()) {
                String key = (String) iter.next();
                String value = prop.getProperty(key);
                map.put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;

        try {
            //创建ServerSocket，监听本机80端口
            serverSocket = new ServerSocket(8080);
            while (true) {
                //获取到客户端对应的socket
                socket = serverSocket.accept();

                //获取输入输出流对象
                outputStream = socket.getOutputStream();
                inputStream = socket.getInputStream();

                //获取HTTP请求部分并解析请求
                //判断本次请求是静态demo.html还是运行在服务端的一段JAVA小程序
                parse(inputStream);
                if(null != url) {
                    if(url.indexOf(".") != -1) {
                        //发送静态资源文件
                        sendStaticResource(outputStream);
                    } else {
                        //发送动态资源
                        sendDynamicResource(outputStream, inputStream);
                    }
                }
                relaxStream(outputStream, inputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            relaxStream(outputStream, inputStream);
            if(null != socket) {
                socket.close();
                socket = null;
            }
        }
    }

    private static void relaxStream(OutputStream outputStream, InputStream inputStream) throws IOException {
        if(null != outputStream) {
            outputStream.close();
            outputStream = null;
        }
        if(null != inputStream) {
            inputStream.close();
            inputStream = null;
        }
    }

    private static void sendDynamicResource(OutputStream outputStream, InputStream inputStream) throws Exception {
        //将HTTP协议的响应行和响应头发送到客户端
        outputStream.write("HTTP/1.1 200 OK\n".getBytes());
        outputStream.write("Server:apache-Coyote/1.1\n".getBytes());
        outputStream.write("Content-Type:text/html;charset=utf-8\n".getBytes());
        outputStream.write("\n".getBytes());

        //判断map中key是否和本次待请求的资源路径一致
        if(map.containsKey(url)) {
            //如果包含指定的key，获取到map中key对应的value部分
            String value = map.get(url);
            //通过反射将对应的java程序加载到内存
            Class clazz = Class.forName(value);
            //执行init方法
            Servlet servlet = (Servlet) clazz.newInstance();
            //执行service方法
            servlet.init();
            servlet.Service(inputStream, outputStream);
        }
    }

    private static void sendStaticResource(OutputStream outputStream) throws IOException {
        //发送静态资源

        //定义一个文件输入流，用户获取静态资源demo01.html中的内容
        byte[] bytes = new byte[2048];

        FileInputStream fileInputStream = null;
        try {
            //创建文件对象File，代表本次要请求的资源demo01.html
            File file = new File(WEB_ROOT, url);
            //如果文件存在
            if(file.exists()) {
                //向客户端输出HTTP协议的响应行/头
                outputStream.write("HTTP/1.1 200 OK\n".getBytes());
                outputStream.write("Server:apache-Coyote/1.1\n".getBytes());
                outputStream.write("Content-Type:text/html;charset=utf-8\n".getBytes());
                outputStream.write("\n".getBytes());
                //获取到文件输入流对象
                fileInputStream = new FileInputStream(file);
                //读取静态资源demo01.html中的内容到数组中
                int ch = fileInputStream.read(bytes);
                while (ch!=-1) {
                    //将读取到数组中的内容通过输出流发送到客户端
                    outputStream.write(bytes, 0, ch);
                    ch = fileInputStream.read(bytes);
                }

            } else {
                //如果文件不存在
                //向客户端响应文件不存在消息
                outputStream.write("HTTP/1.1 404 not found\n".getBytes());
                outputStream.write("Server:apache-Coyote/1.1\n".getBytes());
                outputStream.write("Content-Type:text/html;charset=utf-8\n".getBytes());
                outputStream.write("\n".getBytes());
                String errorMessage = "file not found";
                outputStream.write(errorMessage.getBytes());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(null != null) {
                fileInputStream.close();
                fileInputStream = null;
            }
        }

    }

    private static void parse(InputStream inputStream) throws IOException {
        //读取请求部分，截取请求资源名称
        //定义一个变量，存放HTTP协议请求部分的数据
        StringBuffer content = new StringBuffer(2048);
        //定义一个数组，存放HTTP协议请求部分数据
        byte[] buffer = new byte[2048];
        //定义一个变量i，代表读取数据到数组中之后，数据量的大小
        int i = -1;
        //读取客户端发送过来的数据，将数据读取到字节组buffer中，i表示读取数据量的大小
        i = inputStream.read(buffer);
        //遍历字节数组，将数组中的数据追加到content中
        for(int j=0; j<i; j++) {
            content.append((char) buffer[j]);
        }
        //System.out.println(content.toString());
        //截取客户端请求的资源路径
        parseUrl(content.toString());
    }
    //截取客户端请求的资源路径
    private static void parseUrl(String content) {
        //定义2个变量，存放请求后2个空格位置
        int index1, index2;
        index1 = content.indexOf(" ");
        if(index1 != -1) {
            index2 = content.indexOf(" ", index1+1);
            if(index2 > index1) {
                url = content.substring(index1+2, index2);
            }
        }
        System.out.println(url);
    }
}