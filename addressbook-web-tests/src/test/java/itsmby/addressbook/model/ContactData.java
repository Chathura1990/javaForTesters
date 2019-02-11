package itsmby.addressbook.model;

import java.io.File;
import java.util.Objects;

public class ContactData {

    private int id = Integer.MAX_VALUE;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nickname;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String allPhones;
    private String companyName;
    private String allAddress;
    private String address;
    private String allEmailAddresses;
    private String emailAddress;
    private String emailAddress2;
    private String emailAddress3;
    private String birthMonth;
    private String birthYear;
    private String birthDate;
    private String notes;
    private File photo;

    public ContactData photo(File photo) {
        this.photo = photo;
        return this;
    }

    public ContactData firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public ContactData lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactData homePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactData mobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactData workPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public ContactData allPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public ContactData allAddress(String allAddress) {
        this.allAddress = allAddress;
        return this;
    }

    public ContactData address(String address) {
        this.address = address;
        return this;
    }

    public ContactData allEmailAddresses(String allEmailAddresses) {
        this.allEmailAddresses = allEmailAddresses;
        return this;
    }

    public ContactData emailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public ContactData emailAddress2(String emailAddress2) {
        this.emailAddress2 = emailAddress2;
        return this;
    }

    public ContactData emailAddress3(String emailAddress3) {
        this.emailAddress3 = emailAddress3;
        return this;
    }

    public ContactData birthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public ContactData birthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
        return this;
    }

    public ContactData birthYear(String birthYear) {
        this.birthYear = birthYear;
        return this;
    }

    public ContactData notes(String notes) {
        this.notes = notes;
        return this;
    }

    public ContactData Id(int id) {
        this.id = id;
        return this;
    }

    public int getId() { return id; }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public String getHomePhone() { return homePhone; }

    public String getMobilePhone() { return mobilePhone; }

    public String getWorkPhone() { return workPhone; }

    public String getAllPhones() { return allPhones; }

    public String getCompanyName() {
        return companyName;
    }

    public String getAllAddress() { return allAddress; }

    public String getAddress() { return address; }

    public String getAllEmailAddresses() { return allEmailAddresses; }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getEmailAddress2() {
        return emailAddress2;
    }

    public String getEmailAddress3() {
        return emailAddress3;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getNotes() {
        return notes;
    }

    public File getPhoto() { return photo; }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

}
