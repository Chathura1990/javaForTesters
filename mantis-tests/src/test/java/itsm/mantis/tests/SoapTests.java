package itsm.mantis.tests;

import itsm.mantis.model.Issue;
import itsm.mantis.model.Project;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class SoapTests extends TestBase{

    private Issue issue = new Issue();

    @BeforeMethod
    public void checkIfIssueOpened() throws RemoteException, ServiceException, MalformedURLException {
        skipIfNotFixed(issue.withId(1));
    }

    @Test
    public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {
        Set<Project> projects = app.soap().getProjects();
        System.out.println(projects);
        for(Project project : projects){
            System.out.println(project.getName());
        }
    }

    @Test
    public void testCreateIssue() throws RemoteException, ServiceException, MalformedURLException {
        Set<Project> projects = app.soap().getProjects();
        issue.withSummary("Test issue")
                .withDescription("Test issue description").withProject(projects.iterator().next());
        Issue created = app.soap().addIssue(issue);
        assertEquals(issue.getSummary(), created.getSummary());
    }
}
