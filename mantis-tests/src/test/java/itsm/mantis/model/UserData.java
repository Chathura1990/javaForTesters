package itsm.mantis.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mantis_user_table")
public class UserData {

    @Id
    @Column(name = "id")
    private int id;

    @Expose
    @Column(name = "username")
    private String userName;

    @Expose
    @Column(name = "realname")
    private String realname;

    @Expose
    @Column(name = "email")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public UserData setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getRealname() {
        return realname;
    }

    public UserData setRealname(String realname) {
        this.realname = realname;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserData setUserName(String userName) {
        this.userName = userName;
        return this;
    }


    @Override
    public String toString() {
        return "UserData{" +
                "userName='" + userName + '\'' +
                ", realname='" + realname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return Objects.equals(userName, userData.userName) &&
                Objects.equals(realname, userData.realname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, realname);
    }
}
