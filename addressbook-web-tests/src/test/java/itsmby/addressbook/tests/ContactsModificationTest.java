package itsmby.addressbook.tests;

import itsmby.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactsModificationTest extends TestBase {
    ContactData contactData = new ContactData();

    @Test(priority = 1)
    public void testContactsModification() {
        app.goTo().homePage();
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
        app.goTo().homePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContactToEdit(before.size() - 1);
        ContactData contacts = new ContactData().firstName("Renold").lastName("Lec").companyName("INIZIO.io");
        app.getContactHelper().fillContactForm(contacts);
        app.getContactHelper().clickUpdate();
        app.goTo().homePage();
        List<ContactData> after = app.getContactHelper().getContactList();
//        int after  = app.getContactHelper().getContactCount();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contacts);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
