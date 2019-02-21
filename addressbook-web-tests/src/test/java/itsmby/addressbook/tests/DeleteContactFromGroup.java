package itsmby.addressbook.tests;

import itsmby.addressbook.model.ContactData;
import itsmby.addressbook.model.GroupData;
import itsmby.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteContactFromGroup extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.group().checkAvailabilityOfGroupsAndCreate(new GroupData().withName("Grp1").withHeader("Hdr1"));
        app.contact().checkAvailabilityOfContactsAndCreate(new ContactData().firstName("Cherry").lastName("pick"));
    }

    @Test
    public void testDeleteContactFromGroup(){
        app.goTo().homePage();
        ContactData contact = app.db().contacts().iterator().next();
        Groups groups = app.db().groups();
        GroupData group = groups.iterator().next();
        app.group().selectGroup(groups.iterator().next().getName());
        if (!app.contact().checkAvailabilityOfContacts()){
            app.contact().addToGroup(group,contact);
            app.contact().clickGotoGroupPage();
        }else{
            contact = app.contact().all().iterator().next();
        }
        app.contact().deleteContactInGroups(contact);
        groups.removeAll(contact.getGroups());
        app.db().refreshSession(contact);
        assertThat(contact.getGroups(), not(hasItem(group)));
    }
}
