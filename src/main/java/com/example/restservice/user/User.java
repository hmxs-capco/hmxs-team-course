package com.example.restservice.user;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private String id;

    private String firstname;

    private String lastname;

    public User() {}

    public User(String firstName, String lastName) {
        this.firstname = firstName;
        this.lastname = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, firstname='%s', lastname='%s']",
                id, firstname, lastname);
    }

}
