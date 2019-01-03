package itsmby.addressbook.appmanager;

import itsmby.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void clickSubmit() {
        click(By.name("submit"));
    }

    public void addEmail(ContactData contactData) {
        type(By.name("email"), contactData.getEmailAddress());
    }

    public void addCompanyName(ContactData contactData) {
        type(By.name("company"), contactData.getCompanyName());
    }

    public void addNickName(ContactData contactData) {
        type(By.name("nickname"), contactData.getNickname());
    }

    public void addLastName(ContactData contactData) {
        type(By.name("lastname"), contactData.getLastName());
    }

    public void addMiddleName(ContactData contactData) {
        type(By.name("middlename"), contactData.getMiddleName());
    }

    public void addFirstName(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
    }

    public void clickAddNewButton() {
        click(By.xpath("//*[@id='nav']/ul/li[2]/a"));
    }
}
