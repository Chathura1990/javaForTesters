package itsmby.addressbook.tests;

import itsmby.addressbook.model.ContactData;
import itsmby.addressbook.model.Contacts;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateContactsTest extends TestBase {

    @Test(priority = 2)
    public void testCreateContacts() {
        Contacts before = app.contact().all();
        app.contact().clickAddNewButton();
        File photo = new File("src/test/resources/photo.jpg");
        ContactData contact = new ContactData()
                .firstName("Tony").lastName("Stark").companyName("WorldWar.lk").photo(photo);
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.Id(after.stream().mapToInt(ContactData::getId).max().getAsInt()))));
    }
}
