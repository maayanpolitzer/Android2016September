package com.company;

/**
 * Created by hackeru on 10/10/2016.
 */
public class User {

    private String name;
    private String password;

    public User(String userName, String userPass){
        name = userName;
        password = userPass;
    }

    @Override
    public String toString() {
        return name + ":" + password;
    }

    public String getName(){
        return name;
    }
}
