package com.example.hackeru.childsupportapp;

/**
 * Created by hackeru on 1/12/2017.
 */

public class Contact {

    private String name;
    private String phone;

    public Contact(String name, String phone){
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
