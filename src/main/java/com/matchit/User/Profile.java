package com.matchit.User;

import java.util.Objects;

public class Profile
{

    //Fields
    String name, email, password;

    //Constructors
    public Profile(){}

    public Profile(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }






    //Getters & Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //To String


    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return name.equals(profile.name) &&
                email.equals(profile.email) &&
                password.equals(profile.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, password);
    }

}
