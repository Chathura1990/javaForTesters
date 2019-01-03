package itsmby.addressbook.tests;

import org.testng.annotations.Test;

public class ContactsDeletionTest extends TestBase {

    @Test
    public void testContactDeletion(){
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().acceptDeletion();
        app.getNavigationHelper().goToHomePage();
    }
}
