package com.company;

public class Main {

    static Vehicle[] cars = new Vehicle[4];

    public static void main(String[] args) {

        Person p1 = new Person("Maayan Politzer", 30, "Nahal alexander 4, Tzur Yitzhak");
        Person p2 = new Person("Aviv", 24, "Alenby, Tel aviv");
        Person p4 = new Person("Daniel", 23, "Jerusalem");

        Vehicle v1 = new Vehicle(p1, "BMW", 4, "Black");
        Vehicle v2 = new Vehicle(p2, "Honda", 2, "Black");
        Vehicle v3 = new Vehicle(p2, "Siat", 4, "Blue");
        Vehicle v4 = new Vehicle(p4, "Unknown", 4, "Green");

        cars[0] = v1;
        cars[1] = v2;
        cars[2] = v3;
        cars[3] = v4;


        cars[1].color = "Grey";

        System.out.println(v1.getDetails());
        System.out.println(v2.getDetails());
        System.out.println(v3.getDetails());
        System.out.println(v4.getDetails());
        System.out.println("Vehicle object created: " + Vehicle.counter);

        sendReport(0);
        cars[2].changeOwner(p1, 45000);
        System.out.println(v3.getDetails());
        System.out.println(v2.getDetails());
    }

    public static void sendReport(int lp){
        for (int i = 0; i < cars.length; i++){
            if (cars[i].licensePlace == lp){
                System.out.println(cars[i].owner.address);
                return;
            }
        }
        System.out.println("No such car...");
    }

}
