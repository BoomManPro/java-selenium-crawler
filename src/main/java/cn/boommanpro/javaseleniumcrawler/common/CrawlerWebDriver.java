package cn.boommanpro.javaseleniumcrawler.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.core.io.DefaultResourceLoader;

/**
 * 爬虫WebDriver 工具类
 *
 * @author <a href="mailto:boommanpro@gmail.com">boommanpro</a>
 * @date 2019/9/3 14:59
 * @created by boommanpro
 */
@Slf4j
public class CrawlerWebDriver {

    private static final String[] ARGUMENTS = new String[]{
            //正式启动的时候开启 --headless
//            "--headless"
    };

    private static final String CRAWLER_WEB_DRIVER_SUFFIX = "classpath:browserDriver/chromedriver-win64.exe";

    private CrawlerWebDriver() {
    }

    /**
     * 爬虫初始化
     */
    public static void init() {
        DefaultResourceLoader loader = new DefaultResourceLoader();
        try {
            String filePath = loader.getResource(CRAWLER_WEB_DRIVER_SUFFIX).getFile().getPath();
            System.setProperty("webdriver.chrome.driver", filePath);
        } catch (IOException e) {
            log.error("获取chrome驱动异常", e);
            throw new WebDriverException("获取chrome驱动异常");
        }
    }

    /**
     * 获取默认爬虫配置
     *
     * @return WebDriver
     */
    public static ChromeDriver getDefaultNewDriver() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefsMap = new HashMap<>(1);
        //无图模式
//        prefsMap.put("profile.managed_default_content_settings.images", 2);
        options.setExperimentalOption("prefs", prefsMap);
        for (String argument : ARGUMENTS) {
            options.addArguments(argument);
        }
        return new ChromeDriver(options);
    }
}
