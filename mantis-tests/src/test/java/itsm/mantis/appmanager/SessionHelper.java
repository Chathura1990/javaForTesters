package itsm.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String username, String password) {
        type(By.id("username"), username);
        click(By.xpath("//*[@id='login-form']/fieldset/input[2]"));
        type(By.id("password"), password);
        click(By.xpath("//*[@id='login-form']/fieldset/input[3]"));
    }
}
