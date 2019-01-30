package itsmby.addressbook.model;

import java.util.Objects;

public class ContactDataForAssert {

    private String firstName;
    private String lastName;
    private String companyName;
    private String emailAddress;

    public ContactDataForAssert(String lastName, String firstName, String companyName, String emailAddress) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.companyName = companyName;
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "ContactDataForAssert{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDataForAssert that = (ContactDataForAssert) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
