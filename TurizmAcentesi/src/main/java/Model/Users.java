package Model;

public abstract class Users {
    private int userID;
    private String name;
    private String surname;
    private String username;
    private String password;
    private UserType userType;


    public Users(String name, String surname, String username, String password,UserType userType) {

        this.userType = userType;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;

    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}



