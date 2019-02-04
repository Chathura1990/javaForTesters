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
        app.goTo().homePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().acceptDeletion();
        app.goTo().homePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() -1);
        Assert.assertEquals(before,after);
    }
}
