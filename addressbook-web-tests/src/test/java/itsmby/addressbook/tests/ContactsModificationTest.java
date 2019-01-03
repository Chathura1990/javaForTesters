package itsmby.addressbook.tests;

import itsmby.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactsModificationTest extends TestBase{
    ContactData contactData = new ContactData();

    @Test
    public void testContactsModification(){
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().selectContactToEdit();
        app.getContactHelper().addFirstName(contactData.firstName("Andrey"));
        app.getContactHelper().addCompanyName(contactData.companyName("INIZIO.io"));
        app.getContactHelper().clickUpdate();
    }
}
