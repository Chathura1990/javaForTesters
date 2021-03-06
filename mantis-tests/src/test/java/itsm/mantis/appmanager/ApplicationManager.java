package itsm.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final String browser;
    private final Properties properties;
    private WebDriver wd;
    private RegistrationHelper registrationHelper;
    private FtpHelper ftp;
    private MailHelper mailHelper;
    private ResetPasswordHelper resetPasswordHelper;
    private DbHelper dbHelper;
    private SoapHelper soapHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        String driver = System.getProperty("driver", "browsers");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", driver))));
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    }

    public void stop() {
        if(wd != null) {
            wd.close();
        }
    }

    public HttpSession newSession(){
        return new HttpSession(this);
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }

    public RegistrationHelper registration() {
        if(registrationHelper == null) {
            registrationHelper = new RegistrationHelper(this);
        }
        return registrationHelper;
    }

    public ResetPasswordHelper resetPassword(){
        if(resetPasswordHelper == null){
            resetPasswordHelper = new ResetPasswordHelper(this);
        }
        return resetPasswordHelper;
    }

    public FtpHelper ftp(){
        if(ftp == null) {
            ftp = new FtpHelper(this);
        }
        return ftp;
    }

    public MailHelper mail(){
        if(mailHelper == null){
            mailHelper = new MailHelper(this);
        }
        return mailHelper;
    }

    public DbHelper db(){
        return dbHelper;
    }
    
    public SoapHelper soap(){
        if(soapHelper == null){
            soapHelper = new SoapHelper(this);
        }
        return soapHelper;
    }

    public WebDriver getDriver() {
        if(wd == null){
            if (browser.equals(BrowserType.CHROME)) {
                System.setProperty(properties.getProperty("web.chromeDriver"), properties.getProperty("web.forChrome"));
                wd = new ChromeDriver();
            } else if (browser.equals(BrowserType.FIREFOX)) {
                System.setProperty(properties.getProperty("web.firefoxDriver"), properties.getProperty("web.forFirefox"));
                wd = new FirefoxDriver();
            }
            wd.manage().window().maximize();
            wd.manage().deleteAllCookies();
            wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            wd.get(properties.getProperty("web.baseUrl"));
        }
        return wd;
    }
}
