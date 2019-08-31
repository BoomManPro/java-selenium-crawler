package cn.boommanpro.javaseleniumcrawler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @date 2019/8/30 21:07
 * @created by BoomManPro
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("start selenium");
        ///////////如下为对百度网页进行一次搜索的过程；///////////

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("http://www.baidu.com/");
        //获取页面所有内容
        String pageSource = driver.getPageSource();
        WebElement html = driver.findElement(By.tagName("html"));
        ///////通过元素属性id=kw找到百度输入框，并输入"Selenium java"；
        driver.findElement(By.id("kw")).sendKeys("Selenium java");
        ///////通过元素属性id=su找到百度一下搜索按钮，并对按钮进行点击操作；
        driver.findElement(By.id("su")).click();
        ///////driver.close();  //暂时注释掉
    }
}
