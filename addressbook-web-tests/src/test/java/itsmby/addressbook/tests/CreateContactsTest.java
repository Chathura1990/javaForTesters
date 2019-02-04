package itsmby.addressbook.tests;

import itsmby.addressbook.model.ContactData;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class CreateContactsTest extends TestBase {
    private ContactData contactData = new ContactData();


    public void testCreateContacts() {
        int before = app.contact().getContactCount();
        app.contact().clickAddNewButton();
        ContactData contactData = new ContactData().firstName(RandomStringUtils.randomAlphanumeric(5))
                .middleName(RandomStringUtils.randomAlphanumeric(1))
                .lastName(RandomStringUtils.randomAlphanumeric(5))
                .nickname(RandomStringUtils.randomAlphanumeric(3))
                .companyName("pie.soft")
                .emailAddress(RandomStringUtils.randomAlphanumeric(5)+"@soft.ru")
                .birthDate("4")
                .birthMonth("April")
                .birthYear("1990")
                .notes(RandomStringUtils.randomAlphanumeric(5));
        create(contactData);
        int after  = app.contact().getContactCount();
        Assert.assertEquals(after, before + 1);
    }

    @Test(priority = 2)
    public void testFillContactForm() {
        List<ContactData> before = app.contact().getContactList();
        app.contact().clickAddNewButton();
        ContactData contacts = new ContactData()
                .firstName("Tony").lastName("Stark").companyName("WorldWar.lk");
        create(contacts);
        List<ContactData> after = app.contact().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contacts);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

    private void create(ContactData contacts) {
        app.contact().fillContactForm(contacts);
        app.contact().clickSubmit();
        app.goTo().homePage();
    }


}
