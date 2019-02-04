package itsmby.addressbook.tests;

import itsmby.addressbook.model.ContactData;
import itsmby.addressbook.model.Contacts;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactsDeletionTest extends TestBase {
    private ContactData contactData = new ContactData();

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
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
    }

    @Test
    public void testContactDeletion() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.goTo().homePage();
        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        assertThat(after, equalTo(before.without(deletedContact)));
    }
}
