package com.company;

/**
 * Created by hackeru on 10/6/2016.
 */
public class Person {

    String name;
    int age;
    String address;

    Person(String newName, int newAge, String newAddress){
        name = newName;
        age = newAge;
        address = newAddress;
    }

    public String getDetails(){
        return "Name: " + name + ", age: " + age + ", Address: " + address;
    }

    public void changeName(String newName){
        name = newName;
    }

    public void changeAddress(String newAddress){
        address = newAddress;
    }

}
