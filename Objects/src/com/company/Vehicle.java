package com.company;

/**
 * Created by hackeru on 10/6/2016.
 */

public class Vehicle {

    Person owner;   // default is null.
    String brand;
    int wheels;
    String color;
    int licensePlace;
    int price;
    int hand = 1;
    static int counter;

    Vehicle(Person vehicleOwner, String vehicleBrand,
            int vehicleWheels, String vehicleColor){
        owner = vehicleOwner;
        brand = vehicleBrand;
        wheels = vehicleWheels;
        color = vehicleColor;
        licensePlace = counter++;
    }

    public String getDetails(){
        return "Owner: " + owner.name + ", Brand: " + brand +
                ", Wheels: " + wheels + ", Color: " + color + " hand: " + hand;
    }

    public void changeOwner(Person buyer, int value){
        if (buyer == owner){
            System.out.println("Go home you are drunk!!!");
            return;
        }
        owner = buyer;
        price = value;
        hand++;
    }

}
