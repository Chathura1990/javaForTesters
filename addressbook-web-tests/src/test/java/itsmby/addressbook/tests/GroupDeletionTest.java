package itsmby.addressbook.tests;

import itsmby.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

    @Test
    public void testDeleteGroups() {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", "test", "test"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before - 1);
    }

}
