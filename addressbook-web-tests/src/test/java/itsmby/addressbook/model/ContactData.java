package itsmby.addressbook.model;

public class ContactData {

    private String firstName;
    private String middleName;
    private String lastName;
    private String nickname;
    private String companyName;
    private String emailAddress;
    private String birthMonth;
    private String birthYear;
    private String birthDate;
    private String notes;

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

    public ContactData birthDate(String birthDate){
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

    public String getEmailAddress() { return emailAddress; }

    public String getBirthDate(){ return birthDate; }

    public String getBirthMonth() { return birthMonth; }

    public String getBirthYear() { return birthYear; }


    public String getNotes() { return notes; }
}
