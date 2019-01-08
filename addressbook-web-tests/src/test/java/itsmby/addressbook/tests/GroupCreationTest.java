package itsmby.addressbook.tests;

import itsmby.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroup(new GroupData("test1", "test", "test"));
    }

}
