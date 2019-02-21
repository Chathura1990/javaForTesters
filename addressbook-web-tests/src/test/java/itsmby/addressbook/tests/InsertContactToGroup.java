package itsmby.addressbook.tests;

import itsmby.addressbook.model.ContactData;
import itsmby.addressbook.model.Contacts;
import itsmby.addressbook.model.GroupData;
import itsmby.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class InsertContactToGroup extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.group().checkAvailabilityOfGroupsAndCreate(new GroupData().withName("Grp1").withHeader("Hdr1"));
        app.contact().checkAvailabilityOfContactsAndCreate(new ContactData().firstName("Cherry").lastName("pick"));
    }

    @Test
    public void testInsertContactToGroup(){
        app.goTo().homePage();
        ContactData contact = app.db().contacts().iterator().next();
        Groups groups = app.db().groups();
        app.group().selectGroup(groups.iterator().next().getName());
        if (app.contact().checkAvailabilityOfContacts()){
            app.contact().deleteContactInGroups(contact);
            app.contact().clickGotoGroupPage();
        }
        GroupData group = groups.iterator().next();
        groups.removeAll(contact.getGroups());
        app.contact().addToGroup(group,contact);
        app.db().refreshSession(contact);
        assertThat(contact.getGroups(), hasItem(group));
        }
}
