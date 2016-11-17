package com.company;

import com.company.one.User;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static String name = "Maayan";

    public static void main(String[] args) {
        /*
        int first = 100;
        int second = 52;
        hi();

        int i = sum(first, second);

        System.out.println(i);
        sendSumToManager(i);
        System.out.println(name);
        hi();
        */
        User u2 = new User("Maayan", "123", "maayanp163@gmail.com");

        //User u3 = new User(u2);
        sum(45,6);

    }

    private static void sendSumToManager(int number){

        // send sms to manager...
    }

    private static int sum(int x, int y){
        int number = x+y;
        return number;
    }


    static void hi(){
        System.out.println("Hi " + name);
    }

    public void hello(){
        System.out.println("Hello!!");
    }
}
