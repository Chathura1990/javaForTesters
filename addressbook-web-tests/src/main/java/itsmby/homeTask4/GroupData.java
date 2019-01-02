package itsmby.homeTask4;

public class GroupData {
    private String firstName;
    private String middleName;
    private String lastName;
    private String nickname;
    private String companyName;
    private String emailAddress;

    public GroupData firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public GroupData middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public GroupData lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public GroupData nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public GroupData companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public GroupData emailAddress(String emailAddress) {
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
