package itsmby.addressbook.tests;

import itsmby.addressbook.model.ContactData;
import itsmby.addressbook.model.Contacts;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactsModificationTest extends TestBase {
    ContactData contactData = new ContactData();

    @Test(priority = 1)
    public void testContactsModification() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().createContact(contactData.firstName("James")
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
        Contacts before = app.db().contacts();
        ContactData modifyContact = before.iterator().next();
        ContactData contact = new ContactData().Id(modifyContact.getId()).firstName("Renold").lastName("Lec").nickname("Rel").companyName("INIZIO.io").address(null);
        app.goTo().homePage();
        app.contact().modify(contact);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifyContact).withAdded(contact)));
        verifyContactListInUI();
    }


}
