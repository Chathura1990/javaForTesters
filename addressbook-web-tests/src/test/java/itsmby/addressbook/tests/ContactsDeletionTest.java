package itsmby.addressbook.tests;

import itsmby.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactsDeletionTest extends TestBase {
    ContactData contactData = new ContactData();

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(contactData.firstName("Leck")
                    .middleName("L")
                    .lastName("Kesy")
                    .nickname("Lecs")
                    .companyName("ITDOC")
                    .emailAddress("lecs@itdoc.by")
                    .birthDate("8")
                    .birthMonth("February")
                    .birthYear("1995")
                    .notes("Test"));
        }
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().acceptDeletion();
        app.getNavigationHelper().goToHomePage();
    }
}
