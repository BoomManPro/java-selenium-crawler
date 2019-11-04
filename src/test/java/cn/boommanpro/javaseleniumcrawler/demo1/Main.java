package cn.boommanpro.javaseleniumcrawler.demo1;

import java.util.Set;
import java.util.function.Function;

import cn.boommanpro.javaseleniumcrawler.common.CrawlerWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @date 2019/8/30 21:07
 * @created by BoomManPro
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("start selenium");
        ///////////如下为对百度网页进行一次搜索的过程；///////////

        CrawlerWebDriver.init();

        ChromeDriver driver = CrawlerWebDriver.getDefaultNewDriver();
        driver.get("http://www.baidu.com/");
        //获取页面所有内容
        String pageSource = driver.getPageSource();
        WebElement html = driver.findElement(By.tagName("html"));
        //通过元素属性id=su找到百度一下搜索按钮，并对按钮进行点击操作；
        driver.findElement(By.id("kw")).sendKeys("明略科技");
        WebElement aElement = new WebDriverWait(driver, 2000)
                .until(webDriver -> webDriver.findElement(By.cssSelector("#\\31  > h3 > a")));

        driver.executeScript("arguments[0].click();", aElement);
        driver.close();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
                driver.switchTo().window(windowHandle);
                System.out.println(driver.getCurrentUrl());
        }
        driver.close();  //暂时注释掉
    }
}
