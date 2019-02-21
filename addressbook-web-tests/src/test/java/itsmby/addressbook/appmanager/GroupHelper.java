package itsmby.addressbook.appmanager;

import itsmby.addressbook.model.GroupData;
import itsmby.addressbook.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

    public void selectGroup(String groupName) {
        Select group = new Select(wd.findElement(By.name("group")));
        group.selectByVisibleText(groupName);

    }

    public void checkAvailabilityOfGroupsAndCreate(GroupData grp){
        if(new DbHelper().groups().size() == 0){
            new NavigationHelper(wd).groupPage();
            new GroupHelper(wd).create(new GroupData().withName(grp.getName()).withHeader(grp.getHeader()));
        }
    }

    public void toGroup(int id){
        Select value = new Select(wd.findElement(By.name("to_group")));
        value.selectByValue(Integer.toString(id));
    }

    public String getGroupName(){
        Select option = new Select(wd.findElement(By.name("group")));
        List<WebElement> optionsList = option.getOptions();
        return optionsList.get(1).getText();
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

    public void create(GroupData group){
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
            groupsCache.add(new GroupData().withId(id).withName(name));
        }
        return new Groups(groupsCache);
    }
}
