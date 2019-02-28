package itsm.mantis.tests;

import itsm.mantis.appmanager.HttpSession;
import itsm.mantis.model.MailMessage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;

import java.io.IOException;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void startMailServer(){
        app.mail().start();
    }

    @Test
    public void testRegistration() throws IOException, InterruptedException {
        String user = RandomStringUtils.randomAlphabetic(4);
        String realname = RandomStringUtils.randomAlphabetic(6);
        String password = "password";
        String email = user+"@localhost.localdomain";
        app.registration().start(user, email);
        List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
        String confirmationLink = findConfirmationLink(mailMessages, email);
        app.registration().finish(confirmationLink, realname, password);
        app.registration().clickProceedBtn();
        Thread.sleep(3000);
        HttpSession session = app.newSession();
        assertTrue(session.login(user,realname,password));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        app.mail().stop();
    }
}
