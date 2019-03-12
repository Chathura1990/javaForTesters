package itsmby.addressbook.appmanager;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class ApplicationManager {
    private final String browser;
    private final Properties properties;
    private WebDriver wd;

    private NavigationHelper navigationHelper;
    private ContactHelper contactHelper;
    private GroupHelper groupHelper;
    private DbHelper dbHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        String driver = System.getProperty("driver", "browsers");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", driver))));
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        dbHelper = new DbHelper();
        if("".equals(properties.getProperty("selenium.server"))){
            if (browser.equals(BrowserType.CHROME)) {
                System.setProperty(properties.getProperty("web.chromeDriver"), properties.getProperty("web.forChrome"));
                wd = new ChromeDriver();
            } else if (browser.equals(BrowserType.FIREFOX)) {
                System.setProperty(properties.getProperty("web.firefoxDriver"), properties.getProperty("web.forFirefox"));
                wd = new FirefoxDriver();
            }
        }else{
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            capabilities.setPlatform(Platform.fromString(System.getProperty("platform", "win7")));
            wd = new RemoteWebDriver(new URL(properties.getProperty("selenium.server")), capabilities);
        }
        wd.manage().window().maximize();
        wd.manage().deleteAllCookies();
//        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseUrl"));
        contactHelper = new ContactHelper(wd);
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        new SessionHelper(wd).login(properties
                .getProperty("web.adminLogin"),properties.getProperty("web.adminPassword"));
    }

    public void stop() {
        wd.close();
    }

    public ContactHelper contact() {
        return contactHelper;
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public DbHelper db(){
        return dbHelper;
    }
}
