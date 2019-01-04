package itsmby.addressbook.appmanager;

import itsmby.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void clickSubmit() {
        click(By.name("submit"));
    }

    public void clickUpdate() {
        click(By.name("update"));
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

    public void addBirthDate(ContactData contactData) {
        click(By.name("bday"));
        new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBirthDate());
        click(By.name("bday"));
    }

    public void addBirthMonth(ContactData contactData) {
        click(By.name("bmonth"));
        new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBirthMonth());
        click(By.name("bmonth"));
    }

    public void addBirthYear(ContactData contactData) {
        type(By.name("byear"), contactData.getBirthYear());
    }

    public void addNotes(ContactData contactData){
        type(By.name("notes"), contactData.getNotes());
    }

    public void clickAddNewButton() {
        click(By.xpath("//*[@id='nav']/ul/li[2]/a"));
    }

    public void selectContact() {
        click(By.id(getAttribute(By.xpath("//td//input[@type='checkbox']"))));
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
}
