package itsmby.addressbook.tests;

import itsmby.addressbook.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class TestBase {

    private Logger log = LoggerFactory.getLogger(TestBase.class);

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

    @AfterMethod
    public void logTestStart(Method m, Object[] p){
        log.info("Start test "+m.getName() + " with Parameters " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m, Object[] p){
        log.info("End test "+m.getName() + " with Parameters " + Arrays.asList(p));
    }

}
