package itsm.mantis.appmanager;

import org.openqa.selenium.By;

public class RegistrationHelper extends HelperBase{

    public RegistrationHelper(ApplicationManager app) {
        super(app);
    }

    public void start(String username, String email) {
        wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
        type(By.id("username"),username);
        type(By.id("email-field"), email);
        click(By.cssSelector("input[value='Signup']"));
    }

    public void finish(String confirmationLink, String realname, String password){
        wd.get(confirmationLink);
        type(By.id("realname"),realname);
        type(By.name("password"),password);
        type(By.id("password-confirm"),password);
        click(By.cssSelector("button[type='submit']"));
    }

    public void clickProceedBtn(){
        click(By.xpath("//*[contains(text(),'Proceed')]"));
    }
}
