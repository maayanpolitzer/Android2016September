package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        System.out.println(users);
        /*
        User u1 = new User("maayan", "123");
        users.add(u1);
        */
        users.add(new User("Maayan", "123"));
        users.add(new User("Moshe", "234"));
        System.out.println(users);
        users.remove(0);
        System.out.println(users);

        //System.out.println(u1); // calls u1.toString();
    }
}
