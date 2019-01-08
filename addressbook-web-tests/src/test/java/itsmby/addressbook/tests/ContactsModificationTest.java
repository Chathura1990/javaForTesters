package itsmby.addressbook.tests;

import itsmby.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactsModificationTest extends TestBase{
    ContactData contactData = new ContactData();

    @Test(priority = 1)
    public void testContactsModification(){
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().selectContactToEdit();
        app.getContactHelper().fillContactForm(contactData.firstName("Renold").lastName("Lec").companyName("INIZIO.io"));
        app.getContactHelper().clickUpdate();
        app.getNavigationHelper().goToHomePage();
    }
}
