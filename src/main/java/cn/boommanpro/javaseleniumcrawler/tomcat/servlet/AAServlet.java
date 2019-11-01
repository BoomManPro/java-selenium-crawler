package cn.boommanpro.javaseleniumcrawler.tomcat.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

import cn.boommanpro.javaseleniumcrawler.tomcat.Servlet;

/**
 * @author wangqimeng
 * @date 2019/11/1 14:40
 */
public class AAServlet implements Servlet {


    @Override
    public void init() {
        System.out.println("aaServlet...init");
    }
    @Override
    public void Service(InputStream is, OutputStream os) throws IOException, InterruptedException {
        System.out.println("aaServlet...service");
        for (int i = 0; i < 100; i++) {
            os.write("I'm from AAServlet".getBytes());
            os.flush();
            TimeUnit.SECONDS.sleep(1);
        }
        os.close();
    }
    @Override
    public void destroy() {
        System.out.println("aa...destroy...");
    }
}