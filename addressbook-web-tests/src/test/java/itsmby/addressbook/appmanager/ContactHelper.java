package itsmby.addressbook.appmanager;

import itsmby.addressbook.model.ContactData;
import itsmby.addressbook.model.Contacts;
import itsmby.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    NavigationHelper nvh = new NavigationHelper(wd);
    GroupHelper grph = new GroupHelper(wd);

    public void returnToContactPage() {
        click(By.xpath("//*[@id='content']/div/i/a[2]"));
    }

    public void clickSubmit() {
        click(By.name("submit"));
    }

    public void clickUpdate() {
        click(By.name("update"));
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

    public void initContactModificationById(int id) {
        wd.findElement(By.xpath("//*[@href='edit.php?id="+id+"']")).click();
    }

    public boolean checkAvailabilityOfContacts(){
        return isELementPresent(By.name("selected[]"));
    }

    public void selectFirstContact(){
        click(By.name("selected[]"));
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='"+id+"']")).click();
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("company"), contactData.getCompanyName());
        type(By.name("email"), contactData.getEmailAddress());
        attach(By.name("photo"),contactData.getPhoto());
//        if(creation){
//            Assert.assertTrue(contactData.getGroups().size() == 1);
//            if(contactData.getGroups().size() > 0){
//                System.out.println(contactData.getGroups().size());
//
//                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
//            }else{
//                Assert.assertFalse(isELementPresent(By.name("new_group")));
//            }
//        }
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
       initContactModificationById(contacts.getId());
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

    public void clickGotoGroupPage(){
        click(By.xpath("//*[contains(text(),'group page')]"));
    }

    public void deleteContactInGroups(ContactData cnt){
        WebDriverWait wait = new WebDriverWait(wd,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='"+cnt.getId()+"']"))).click();
        click(By.name("remove"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public ContactData infoFromEditForm(ContactData contact){
        initContactModificationById(contact.getId());
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String email1 = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().Id(contact.getId()).firstName(firstName).lastName(lastName)
                .address(address).emailAddress(email1).emailAddress2(email2).emailAddress3(email3)
                .homePhone(home).mobilePhone(mobile).workPhone(work);
    }

    private Contacts contactsCache = null;

    public Contacts all() {
        if(contactsCache != null){
            return new Contacts(contactsCache);
        }
        contactsCache = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> Columns_row = row.findElements(By.tagName("td"));
                int id = Integer.parseInt(Columns_row.get(0).findElement(By.tagName("input")).getAttribute("value"));
                String lastName = Columns_row.get(1).getText();
                String firstName = Columns_row.get(2).getText();
                String address = Columns_row.get(3).getText();
                String allEmails = Columns_row.get(4).getText();
                String allPhones = Columns_row.get(5).getText();
                contactsCache.add(new ContactData().Id(id).lastName(lastName).firstName(firstName).allAddress(address)
                        .allEmailAddresses(allEmails).allPhones(allPhones));
            }
        return new Contacts(contactsCache);
    }

    public void addToGroup(GroupData group, ContactData cnt) {
        if(!isELementPresent(By.name("selected[]"))) {
            nvh.homePageWithoutFilters();
            selectContactById(cnt.getId());
            grph.toGroup(group.getId());
            click(By.name("add"));
        }
    }

    public void checkAvailabilityOfContactsAndCreate(ContactData cnt) {
        if (new DbHelper().contacts().size() == 0){
            nvh.homePageWithoutFilters();
            new ContactHelper(wd).createContact(cnt);
            nvh.homePageWithoutFilters();
        }
    }
}
