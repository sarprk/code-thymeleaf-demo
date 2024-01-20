package com.javalearn.codethymeleafdemo.model;

public class User {
    private final String name;

    public User(String name, String email, String role, String gender) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.gender = gender;
    }

    private final String email;

    public String getName() {
        return name;
    }



    public final String getEmail() {
        return email;
    }


    public final String getRole() {
        return role;
    }


    public String getGender() {
        return gender;
    }



    private String role;
    private String gender;

}
