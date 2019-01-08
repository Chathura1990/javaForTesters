package itsmby.addressbook.appmanager;

import org.openqa.selenium.*;

public class HelperBase {
    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected WebElement click(By locator) {
        wd.findElement(locator).click();
        return null;
    }

    protected void type(By locator, String text) {
        click(locator);
        if (text != null) {
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }

    protected String getAttribute(By locator) {
        return wd.findElement(locator).getAttribute("value");

    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected boolean isELementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
