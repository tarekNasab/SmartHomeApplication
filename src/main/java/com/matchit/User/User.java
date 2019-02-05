package com.matchit.User;

public class User {
    String userF_Name;
    String user_email;
    String user_password;


    //Constructors

    public User() {};
    public User(String userF_Name, String user_email, String user_password) {
        this.userF_Name = userF_Name;
        this.user_email = user_email;
        this.user_password = user_password;
    }



    //Getters and Setters

    public String getUserF_Name() {
        return userF_Name;
    }

    public String getUser_email() {
        return user_email;
    }

    public String getUser_password() {
        return user_password;
    }



    //

    public void setUserF_Name(String userF_Name) {
        this.userF_Name = userF_Name;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }









    //ToString

    @Override
    public String toString() {
        return "User{" +
                "userF_Name='" + userF_Name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_password='" + user_password + '\'' +
                '}';
    }
}
