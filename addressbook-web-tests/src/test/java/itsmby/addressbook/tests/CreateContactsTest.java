package itsmby.addressbook.tests;

import itsmby.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class CreateContactsTest extends TestBase {
    ContactData contactData = new ContactData();

    @Test(priority = 1)
    public void testCreateContacts() {
       app.getContactHelper().clickAddNewButton();
       app.getContactHelper()
               .fillContactForm(contactData.firstName("Tony")
               .middleName("m")
               .lastName("Shadow")
               .nickname("Ton")
               .companyName("pie.soft")
               .emailAddress("ton.pie@soft.ru")
               .birthDate("4")
               .birthMonth("April")
               .birthYear("1990")
               .notes("Test"));
       app.getContactHelper().clickSubmit();
       app.getNavigationHelper().goToHomePage();
    }

    @Test(priority = 2)
    public void testFillContactForm(){
        app.getContactHelper().clickAddNewButton();
        app.getContactHelper()
                .fillContactForm(contactData.firstName("Artem")
                .middleName("V")
                .lastName("Drabysheuski")
                .nickname("Arta").companyName("IT Doc")
                .emailAddress("Arta@itdoc.by"));
        app.getContactHelper().clickSubmit();
        app.getNavigationHelper().goToHomePage();
    }




}
