package itsmby.addressbook.tests;

import itsmby.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactsDeletionTest extends TestBase {
    private ContactData contactData = new ContactData();

    @Test
    public void testContactDeletion() {
        app.goTo().homePage();
        if (!app.contact().isThereAContact()) {
            app.contact().createContact(contactData.firstName("Leck")
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
        app.goTo().homePage();
        List<ContactData> before = app.contact().getContactList();
        app.contact().selectContact(before.size() - 1);
        app.contact().deleteSelectedContact();
        app.contact().acceptDeletion();
        app.goTo().homePage();
        List<ContactData> after = app.contact().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() -1);
        Assert.assertEquals(before,after);
    }
}
