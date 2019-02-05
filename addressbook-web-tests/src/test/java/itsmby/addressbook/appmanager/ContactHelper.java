package itsmby.addressbook.appmanager;

import itsmby.addressbook.model.ContactData;
import itsmby.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.management.relation.InvalidRelationTypeException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToContactPage() {
        click(By.xpath("//*[@id='content']/div/i/a[2]"));
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

    public void createContact(ContactData contacts) {
        clickAddNewButton();
        fillContactForm(contacts);
        clickSubmit();
        contactsCache = null;
    }

    public void create(ContactData contacts) {
       fillContactForm(contacts);
       clickSubmit();
       contactsCache = null;
       returnToContactPage();
    }

    public void modify(ContactData contacts) {
       selectContactToEditById(contacts.getId());
       fillContactForm(contacts);
       clickUpdate();
       contactsCache = null;
    }

    public void delete(ContactData deletedContact) {
       selectContactById(deletedContact.getId());
       deleteSelectedContact();
       acceptDeletion();
       contactsCache = null;
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void clickAddNewButton() {
        click(By.xpath("//*[@id='nav']/ul/li[2]/a"));
    }

    public void deleteSelectedContact() {
        click(By.xpath("//*[@id='content']/form[2]/div[2]/input"));
    }

    public void acceptDeletion() {
        wd.switchTo().alert().accept();
    }

    public void selectContactToEditById(int id) {
        wd.findElement(By.xpath("//*[@href='edit.php?id="+id+"']")).click();
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='"+id+"']")).click();
    }

    private Contacts contactsCache = null;

    public Contacts all() {
        if (contactsCache != null){
            return new Contacts(contactsCache);
        }
        contactsCache = new Contacts();
        WebElement table = wd.findElement(By.xpath("//*[@id='maintable']/tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> Columns_row = row.findElements(By.tagName("td"));
            int columns_count = Columns_row.size();
            if (columns_count>0) {
                String lastName = Columns_row.get(1).getText();
                String firstName = Columns_row.get(2).getText();
                int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
                ContactData contact = new ContactData().Id(id).lastName(lastName).firstName(firstName);
                contactsCache.add(contact);
            }
        }
        return contactsCache;
    }
}
