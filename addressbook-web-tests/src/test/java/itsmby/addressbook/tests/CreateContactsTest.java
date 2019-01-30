package itsmby.addressbook.tests;

import itsmby.addressbook.model.ContactData;
import itsmby.addressbook.model.ContactDataForAssert;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class CreateContactsTest extends TestBase {
    private ContactData contactData = new ContactData();


    public void testCreateContacts() {
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().clickAddNewButton();
        app.getContactHelper()
                .fillContactForm(contactData.firstName(RandomStringUtils.randomAlphanumeric(5))
                        .middleName(RandomStringUtils.randomAlphanumeric(1))
                        .lastName(RandomStringUtils.randomAlphanumeric(5))
                        .nickname(RandomStringUtils.randomAlphanumeric(3))
                        .companyName("pie.soft")
                        .emailAddress(RandomStringUtils.randomAlphanumeric(5)+"@soft.ru")
                        .birthDate("4")
                        .birthMonth("April")
                        .birthYear("1990")
                        .notes(RandomStringUtils.randomAlphanumeric(5)));
        app.getContactHelper().clickSubmit();
        app.getNavigationHelper().goToHomePage();
        int after  = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
    }

    @Test(priority = 2)
    public void testFillContactForm() {
        List<ContactDataForAssert> before = app.getContactHelper().getContactList();
        app.getContactHelper().clickAddNewButton();
        ContactDataForAssert contacts = new ContactDataForAssert("Tony","Stark","WorldWar.lk",null);
        app.getContactHelper()
                .fillContactsData(contacts);
        app.getContactHelper().clickSubmit();
        app.getNavigationHelper().goToHomePage();
        List<ContactDataForAssert> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contacts);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }


}
