package itsm.mantis.tests;

import itsm.mantis.model.MailMessage;
import itsm.mantis.model.UserData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;

import java.io.IOException;
import java.util.List;

public class ResetPassword extends TestBase {

    @BeforeMethod
    public void startMailServerAndSession(){
        app.mail().start();
        app.resetPassword().createSession();
    }

    @Test
    public void testResetPassword() throws InterruptedException, IOException {
        List<UserData> result = app.resetPassword().getUserData();
        String userName = result.iterator().next().getUserName();
        String realName = result.iterator().next().getRealname();
        String userEmail = result.iterator().next().getEmail();
        String admin = "Administrator" ;
        String adminPass = "root";
        String newPass = "password";
        app.resetPassword().start(admin,adminPass);
        app.resetPassword().selectAUserToResetPass(userName);
        app.resetPassword().clickRestPassBtn();
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        String confirmationLink = findConfirmationLink(mailMessages, userEmail);
        app.resetPassword().finish(confirmationLink,newPass);
        Thread.sleep(3000);
        Assert.assertTrue(app.newSession().login(userName,realName,newPass));
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
