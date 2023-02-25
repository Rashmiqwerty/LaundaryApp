package com.example.myapplicationlaundary;

public class Profile {

    String email,password;

    public Profile() {
    }

    public Profile(String email, String password) {

        this.email = email;

        this.password = password;
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
}
