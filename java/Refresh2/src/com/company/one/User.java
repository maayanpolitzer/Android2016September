package com.company.one;

/**
 * Created by hackeru on 11/17/2016.
 */
public class User {

    private String name;
    private String password;
    private String email;
    private Car car;

    public User(String name, String password, String email){
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User(String name, String email){
        this(name, "", email);
        password = generateRandomPassword();
        System.out.println("You r new password is: " + password);
    }

    public User(User copyUser){
        name = copyUser.name;
    }

    private String generateRandomPassword(){
        return "123abd";
    }

    public String getName(){
        return name;
    }

    /*
    public Car getCar() {
        return new Car(car);    // aliasing.
    }
    */
    
}
