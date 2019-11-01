package cn.boommanpro.javaseleniumcrawler.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * @author wangqimeng
 * @date 2019/11/1 14:39
 */
public interface Servlet {//所有服务端JAVA要实现的接口
    //初始化
    public void init();
    //服务
    public void Service(InputStream is, OutputStream os) throws IOException, InterruptedException;
    //销毁
    public void destroy();
}
