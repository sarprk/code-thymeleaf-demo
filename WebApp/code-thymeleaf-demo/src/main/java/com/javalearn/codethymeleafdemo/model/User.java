package com.javalearn.codethymeleafdemo.model;

public class User {
    private String name;

    public User(String name, String email, String role, String gender) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.gender = gender;
    }

    private String email;

    public String getName() {
        return name;
    }



    public String getEmail() {
        return email;
    }


    public String getRole() {
        return role;
    }


    public String getGender() {
        return gender;
    }



    private String role;
    private String gender;

}
