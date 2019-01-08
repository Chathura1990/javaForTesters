package itsmby.addressbook.tests;

import itsmby.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactsModificationTest extends TestBase {
    ContactData contactData = new ContactData();

    @Test(priority = 1)
    public void testContactsModification() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(contactData.firstName("James")
                    .middleName("R")
                    .lastName("Detroit")
                    .nickname("Deta")
                    .companyName("Umbrella.uk")
                    .emailAddress("deta@umbrella.uk")
                    .birthDate("5")
                    .birthMonth("June")
                    .birthYear("1985")
                    .notes("Hello"));
        }
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().selectContactToEdit();
        app.getContactHelper().fillContactForm(contactData.firstName("Renold")
                .lastName("Lec")
                .companyName("INIZIO.io")
                .nickname(null)
                .emailAddress(null)
                .birthDate(null)
                .birthMonth(null)
                .birthYear(null)
                .notes(null));
        app.getContactHelper().clickUpdate();
        app.getNavigationHelper().goToHomePage();
    }
}
