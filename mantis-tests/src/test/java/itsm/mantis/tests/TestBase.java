package itsm.mantis.tests;

import itsm.mantis.appmanager.ApplicationManager;
import itsm.mantis.model.Issue;
import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;

public class TestBase {

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
        Path currentRelativePath = Paths.get("");//getting current path
        String path = currentRelativePath.toAbsolutePath().toString();
        app.ftp().upload(new File(path + "/src/test/resources/config_inc.php"), "config_inc.php","config_inc.php.bak");
    }

    @AfterSuite
    public void tearDown() throws IOException {
        app.ftp().restore("config_inc.php.bak", "config_inc.php");
        app.stop();
    }

    public void skipIfNotFixed(Issue issueId) throws RemoteException, ServiceException, MalformedURLException {
        if (isIssueOpen(issueId.getId())) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    public boolean isIssueOpen(int issueId) throws RemoteException, ServiceException, MalformedURLException {
        return !app.soap().getIssue(issueId).isResolved();
    }

}
