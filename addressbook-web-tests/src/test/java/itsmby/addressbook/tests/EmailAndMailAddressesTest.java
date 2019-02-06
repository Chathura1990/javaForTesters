package itsmby.addressbook.tests;

import itsmby.addressbook.model.ContactData;
import org.testng.annotations.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EmailAndMailAddressesTest extends TestBase {

    @Test
    public void testEmailAddresses() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllEmailAddresses(), equalTo(mergeEmailAddresses(contactInfoFromEditForm)));
    }

    @Test
    public void testMailAddresses(){
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(cleaned(contact.getAllAddress()), equalTo(mergeMailAddresses(contactInfoFromEditForm)));
    }

    private String mergeEmailAddresses(ContactData contact) {
        return Stream.of(contact.getEmailAddress(), contact.getEmailAddress2(), contact.getEmailAddress3()).filter((s) -> ! s.equals(""))
                .map(EmailAndMailAddressesTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

    private String mergeMailAddresses(ContactData contact) {
        return Stream.of(contact.getAddress()).filter((s) -> ! s.equals(""))
                .map(EmailAndMailAddressesTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

    private static String cleaned(String addresses){
        return addresses.replaceAll("\\s","");
    }


}
