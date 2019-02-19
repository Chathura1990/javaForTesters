package itsmby.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {

    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;
    @Expose
    @Column(name = "firstname")
    private String firstName;
    @Expose
    @Transient
    private String middleName;
    @Expose
    @Column(name = "lastname")
    private String lastName;
    @Expose
    @Column(name = "nickname")
    private String nickname;
    @Expose
    @Transient
    private String homePhone;
    @Transient
    private String mobilePhone;
    @Transient
    private String workPhone;
    @Transient
    private String allPhones;
    @Expose
    @Column(name = "company")
    private String companyName;
    @Transient
    private String allAddress;
    @Column(name = "address")
    @Type(type = "text")
    @Transient
    private String address;
    @Transient
    private String allEmailAddresses;
    @Expose
    @Transient
    private String emailAddress;
    @Transient
    private String emailAddress2;
    @Transient
    private String emailAddress3;
    @Transient
    private String birthMonth;
    @Transient
    private String birthYear;
    @Transient
    private String birthDate;
    @Transient
    private String notes;
    @Expose
    @Transient
    private String photo;

    public ContactData Id(int id) {
        this.id = id;
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

    public ContactData photo(File photo) {
        this.photo = photo.getPath();
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

    public File getPhoto() {
        if (photo == null) {
            return null;
        }
        return new File(photo);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(nickname, that.nickname) &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, nickname, companyName, address);
    }
}
