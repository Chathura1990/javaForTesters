package itsmby.addressbook.model;

public class ContactData {
    private String firstName;
    private String middleName;
    private String lastName;
    private String nickname;
    private String companyName;
    private String emailAddress;

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

    public ContactData companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public ContactData emailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

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

    public String getCompanyName() {
        return companyName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
