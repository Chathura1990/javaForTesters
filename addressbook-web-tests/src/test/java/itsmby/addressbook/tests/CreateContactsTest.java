package itsmby.addressbook.tests;

import itsmby.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class CreateContactsTest extends TestBase {
    ContactData contactData = new ContactData();

    @Test
    public void testCreateContacts() {
       app.getContactHelper().clickAddNewButton();
       app.getContactHelper().addFirstName(contactData.firstName("Tony"));
       app.getContactHelper().addMiddleName(contactData.middleName("m"));
       app.getContactHelper().addLastName(contactData.lastName("Shadow"));
       app.getContactHelper().addNickName(contactData.nickname("Ton"));
       app.getContactHelper().addCompanyName(contactData.companyName("Pie.soft"));
       app.getContactHelper().addEmail(contactData.emailAddress("ton.pie@soft.eu"));
       app.getContactHelper().addBirthDate(contactData.birthDate("4"));
       app.getContactHelper().addBirthMonth(contactData.birthMonth("April"));
       app.getContactHelper().addBirthYear(contactData.birthYear("1990"));
       app.getContactHelper().addNotes(contactData.notes("Test"));
       app.getContactHelper().clickSubmit();
       app.getNavigationHelper().goToHomePage();
    }




}
