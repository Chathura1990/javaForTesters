package itsmby.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

    @Test
    public void testDeleteGroups() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }

}
