package itsm.mantis.appmanager;

import itsm.mantis.model.UserData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.openqa.selenium.By;

import java.util.List;

public class ResetPasswordHelper extends HelperBase {

    private SessionFactory sessionFactory;

    public ResetPasswordHelper(ApplicationManager app) {
        super(app);
    }

    public void createSession() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            e.printStackTrace();
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    public List<UserData> getUserData() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<UserData> result = session.createQuery( "from UserData WHERE username <> 'administrator'" ).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }


    public void start(String username, String password) {
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.id("username"), username);
        click(By.cssSelector("input[type='submit']"));
        type(By.id("password"), password);
        click(By.cssSelector("input[type='submit']"));
    }

    public void selectAUserToResetPass(String user){
        click(By.xpath("//*[@id='sidebar']/ul/li[6]/a/i"));
        click(By.xpath("//*[@id='main-container']/div[2]/div[2]/div/ul/li[2]/a"));
        click(By.xpath("//*[contains(text(),'"+user+"')]"));
    }

    public void clickRestPassBtn(){
        click(By.cssSelector("input[value='Reset Password']"));
    }

    public String getUserEmail(){
        return getAttribute(By.id("email-field"));
    }

    public void finish(String confirmationLink, String newPass) {
        wd.get(confirmationLink);
        type(By.name("password"),newPass);
        type(By.id("password-confirm"),newPass);
        click(By.cssSelector("button[type='submit']"));
    }

    public void clickProceedBtn(){
        click(By.xpath("//*[contains(text(),'Proceed')]"));
    }
}
