package dev.deej_tsn.Blog.entity;
import java.sql.Timestamp;
import java.util.Objects;

public class User {

    String userID;
    String firstName;
    String secondName;
    String email;
    String userName;
    String salt;
    String passhash;
    Timestamp createdOn;
    Timestamp lastLogin;


    public User() {
    }


    public String getSalt() {
        return this.salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPasshash() {
        return this.passhash;
    }

    public void setPasshash(String passhash) {
        this.passhash = passhash;
    }

    public User salt(String salt) {
        setSalt(salt);
        return this;
    }

    public User passhash(String passhash) {
        setPasshash(passhash);
        return this;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getLastLogin() {
        return this.lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(userID, user.userID) && Objects.equals(firstName, user.firstName) && Objects.equals(secondName, user.secondName) && Objects.equals(email, user.email) && Objects.equals(userName, user.userName) && Objects.equals(createdOn, user.createdOn) && Objects.equals(lastLogin, user.lastLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, firstName, secondName, email, userName, createdOn, lastLogin);
    }

    @Override
    public String toString() {
        return "{" +
            " userID='" + getUserID() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", secondName='" + getSecondName() + "'" +
            ", email='" + getEmail() + "'" +
            ", userName='" + getUserName() + "'" +
            ", createdOn='" + getCreatedOn() + "'" +
            ", lastLogin='" + getLastLogin() + "'" +
            "}";
    }
    
    
}
