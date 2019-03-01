package itsm.mantis.appmanager;

import org.openqa.selenium.By;

public class ResetPasswordHelper extends HelperBase {

    public ResetPasswordHelper(ApplicationManager app) {
        super(app);
    }


    public void start(String username, String password) {
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.id("username"), username);
        click(By.cssSelector("input[type='submit']"));
        type(By.id("password"), password);
        click(By.cssSelector("input[type='submit']"));
    }

    public void selectAUserToResetPass(String user){
        click(By.xpath("//*[@id='sidebar']/ul/li[6]/a/i"));
        click(By.xpath("//*[@id='main-container']/div[2]/div[2]/div/ul/li[2]/a"));
        click(By.xpath("//*[contains(text(),'"+user+"')]"));
    }

    public void clickRestPassBtn(){
        click(By.cssSelector("input[value='Reset Password']"));
    }

    public String getUserEmail(){
        return getAttribute(By.id("email-field"));
    }

    public void finish(String confirmationLink, String newPass) {
        wd.get(confirmationLink);
        type(By.name("password"),newPass);
        type(By.id("password-confirm"),newPass);
        click(By.cssSelector("button[type='submit']"));
    }

    public void clickProceedBtn(){
        click(By.xpath("//*[contains(text(),'Proceed')]"));
    }
}
