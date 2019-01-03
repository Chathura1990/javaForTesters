package itsmby.addressbook.tests;

import itsmby.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class CreateContactsTest extends TestBase {
    ContactData contactData = new ContactData();

    @Test
    public void testCreateContacts() {
       app.getContactHelper().clickAddNewButton();
       app.getContactHelper().addFirstName(contactData.firstName("Chathura"));
       app.getContactHelper().addMiddleName(contactData.middleName("S"));
       app.getContactHelper().addLastName(contactData.lastName("Rajapakse"));
       app.getContactHelper().addNickName(contactData.nickname("Chath"));
       app.getContactHelper().addCompanyName(contactData.companyName("ITSM"));
       app.getContactHelper().addEmail(contactData.emailAddress("chathurasanjeew@gmail.com"));
       app.getContactHelper().clickSubmit();
       app.getNavigationHelper().goToHomePage();
    }




}
