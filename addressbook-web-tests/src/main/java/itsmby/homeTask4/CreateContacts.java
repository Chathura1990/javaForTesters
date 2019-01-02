package itsmby.homeTask4;

import itsmby.setupAndLogin.SetupAndLogin;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CreateContacts extends SetupAndLogin {
    GroupData groupData = new GroupData();

    @Test
    public void testCreateContacts() {
        clickAddNewButton();
        addFirstName(groupData.firstName("Chathura"));
        addMiddleName(groupData.middleName("S"));
        addLastName(groupData.lastName("Rajapakse"));
        addNickName(groupData.nickname("Chath"));
        addCompanyName(groupData.companyName("ITSM"));
        addEmail(groupData.emailAddress("chathurasanjeew@gmail.com"));
        clickSubmit();
        returnToHome();
    }

    private void returnToHome() {
        wd.findElement(By.linkText("home")).click();
    }

    private void clickSubmit() {
        wd.findElement(By.name("submit")).click();
    }

    private void addEmail(GroupData groupData) {
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(groupData.getEmailAddress());
    }

    private void addCompanyName(GroupData groupData) {
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(groupData.getCompanyName());
    }

    private void addNickName(GroupData groupData) {
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(groupData.getNickname());
    }

    private void addLastName(GroupData groupData) {
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(groupData.getLastName());
    }

    private void addMiddleName(GroupData groupData) {
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(groupData.getMiddleName());
    }


    private void addFirstName(GroupData groupData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(groupData.getFirstName());
    }

    private void clickAddNewButton() {
        wd.findElement(By.linkText("add new")).click();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        wd.quit();
    }

}
