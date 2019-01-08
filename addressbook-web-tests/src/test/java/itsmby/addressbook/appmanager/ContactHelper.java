package itsmby.addressbook.appmanager;

import itsmby.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void clickSubmit() {
        click(By.name("submit"));
    }

    public void clickUpdate() {
        click(By.name("update"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("company"), contactData.getCompanyName());
        type(By.name("email"), contactData.getEmailAddress());
        if(contactData.getBirthDate() != null){
            click(By.name("bday"));
            new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBirthDate());
            click(By.name("bday"));
        }
        if(contactData.getBirthMonth() != null) {
            click(By.name("bmonth"));
            new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBirthMonth());
            click(By.name("bmonth"));
        }
        type(By.name("byear"), contactData.getBirthYear());
        type(By.name("notes"), contactData.getNotes());
    }

    public void clickAddNewButton() {
        click(By.xpath("//*[@id='nav']/ul/li[2]/a"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteSelectedContact() {
        click(By.xpath("//*[@id='content']/form[2]/div[2]/input"));
    }

    public void acceptDeletion() {
        wd.switchTo().alert().accept();
    }

    public void selectContactToEdit() {
        click(By.xpath("//*[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public boolean isThereAContact() {
        return isELementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contacts) {
        clickAddNewButton();
        fillContactForm(contacts);
        clickSubmit();
    }
}
