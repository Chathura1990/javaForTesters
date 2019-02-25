package itsm.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {
    private final String browser;
    private final Properties properties;
    private WebDriver wd;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        String driver = System.getProperty("driver", "browsers");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", driver))));
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        if (browser.equals(BrowserType.CHROME)) {
            System.setProperty(properties.getProperty("web.chromeDriver"), properties.getProperty("web.forChrome"));
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            System.setProperty(properties.getProperty("web.firefoxDriver"), properties.getProperty("web.forFirefox"));
            wd = new FirefoxDriver();
        }
        wd.manage().window().maximize();
        wd.manage().deleteAllCookies();
//        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseUrl"));
    }

    public void stop() {
        wd.close();
    }
}
