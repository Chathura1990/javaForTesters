package itsmby.addressbook.appmanager;

import itsmby.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//*[@id='content']/form[2]/div[2]/input"));
    }

    public void acceptDeletion() {
        wd.switchTo().alert().accept();
    }

    public void selectContactToEdit(int index) {
        wd.findElements(By.xpath("//*[@src='icons/pencil.png']")).get(index).click();
//        click(By.xpath("//*[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public boolean isThereAContact() {
        return isELementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contacts) {
        clickAddNewButton();
        fillContactForm(contacts);
        clickSubmit();
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        WebElement table = wd.findElement(By.xpath("//*[@id='maintable']/tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> Columns_row = row.findElements(By.tagName("td"));
            int columns_count = Columns_row.size();
            if (columns_count>0) {
                String lastName = Columns_row.get(1).getText();
                String firstName = Columns_row.get(2).getText();
                ContactData contact = new ContactData().lastName(lastName).firstName(firstName);
                contacts.add(contact);
            }
        }
        return contacts;
    }

    public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<>();
        WebElement table = wd.findElement(By.xpath("//*[@id='maintable']/tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> Columns_row = row.findElements(By.tagName("td"));
            int columns_count = Columns_row.size();
            if (columns_count>0) {
                String lastName = Columns_row.get(1).getText();
                String firstName = Columns_row.get(2).getText();
                ContactData contact = new ContactData().lastName(lastName).firstName(firstName);
                contacts.add(contact);
            }
        }
        return contacts;
    }

}
