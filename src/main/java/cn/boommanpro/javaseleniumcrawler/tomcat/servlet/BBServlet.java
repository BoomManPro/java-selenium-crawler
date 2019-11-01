package cn.boommanpro.javaseleniumcrawler.tomcat.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cn.boommanpro.javaseleniumcrawler.tomcat.Servlet;

/**
 * @author wangqimeng
 * @date 2019/11/1 14:41
 */
public class BBServlet implements Servlet {
    @Override
    public void init() {
        System.out.println("bbServlet...init");
    }
    @Override
    public void Service(InputStream is, OutputStream os) throws IOException {
        System.out.println("bbServlet...service");
        os.write("I'm from BBServlet".getBytes());
        os.flush();
        os.close();
    }
    @Override
    public void destroy() {
        System.out.println("bb...destroy...");
    }
}