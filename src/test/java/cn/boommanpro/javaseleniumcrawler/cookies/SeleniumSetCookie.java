package cn.boommanpro.javaseleniumcrawler.cookies;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

/**
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @date 2019/8/31 16:48
 * @created by BoomManPro
 */
public class SeleniumSetCookie {
    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.boommanpro.cn");
        //先访问
        //再设置cookie
        //然后再访问
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println();
    }
}
