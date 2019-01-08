package itsmby.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        if (isELementPresent(By.tagName("hi"))
                && wd.findElement(By.tagName("hi")).getText().equals("Groups")
                && isELementPresent(By.name("new"))) {
            return;
        }
        click(By.linkText("groups"));
    }

    public void goToHomePage() {
        if (isELementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }
}
