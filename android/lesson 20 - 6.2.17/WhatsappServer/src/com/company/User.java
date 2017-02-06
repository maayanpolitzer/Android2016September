package com.company;

/**
 * Created by maayanpolitzer on 06/02/2017.
 */
public class User {

    private static int counter = 0;

    private String name;
    private String password;
    private int id;

    public User(String[] arr){
        this(arr[0],arr[1]);
    }

    public User(String name, String password){
        this.name = name;
        this.password = password;
        id = ++counter;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }


}
