package itsmby.addressbook.appmanager;

import itsmby.addressbook.model.GroupData;
import itsmby.addressbook.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }


    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.xpath("//*[@id='content']/form/input[5]"));
    }

    private void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='"+id+"']")).click();
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public int count(){
        return wd.findElements(By.name("selected[]")).size();
    }

    public void create(GroupData group) throws InterruptedException {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        groupsCache = null;
        returnToGroupPage();
    }

    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        groupsCache = null;
        returnToGroupPage();
    }

    public void delete(GroupData deleteGroup) {
        selectGroupById(deleteGroup.getId());
        deleteSelectedGroups();
        groupsCache = null;
        returnToGroupPage();
    }

    private Groups groupsCache = null;

    public Groups all(){
        if(groupsCache != null){
            return new Groups(groupsCache);
        }
        groupsCache = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData().withId(id).withName(name);
            groupsCache.add(group);
        }
        return new Groups(groupsCache);
    }
}
