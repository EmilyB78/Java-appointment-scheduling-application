package model;

public class User {
    public int userID;
    public String userName;
    public String userPassword;

    public User(int userID, String userName, String userPassword){
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public int getUserID() {        return userID;    }

    public void setUserID(int userID) {        this.userID = userID;    }

    public String getUserName() {        return userName;    }

    public void setUserName(String userName) {        this.userName = userName;    }

    public String getUserPassword() {        return userPassword;    }

    public void setUserPassword(String userPassword) {        this.userPassword = userPassword;    }
}
