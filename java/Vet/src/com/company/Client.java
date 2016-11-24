package com.company;

import java.util.ArrayList;

/**
 * Created by hackeru on 11/3/2016.
 */
public class Client {

    private String name;
    private int clientID;
    private String phoneNumber;
    private ArrayList<Animal> pets;
    private boolean adsPermission;
    private static int counter = 0;

    public Client(String name, String phoneNumber){
        this(name, phoneNumber, true);
    }

    public Client(String name, String phoneNumber, boolean ads){
        this.name = name;
        this.phoneNumber = phoneNumber;
        pets = new ArrayList<>();
        adsPermission = ads;
        clientID = ++counter;
    }

    @Override
    public String toString() {
        return clientID + ": " + name + ", " + phoneNumber;
    }

    public boolean addAnimal(Animal animal) {
        for (int i = 0; i < pets.size(); i++){
            if (pets.get(i).getAnimalID() == animal.getAnimalID()){
                return false;
            }
        }
        pets.add(animal);
        return true;

        /*
        if (!pets.contains(animal)){
            pets.add(animal);
            return true;
        }
        return false;
        */
    }

    public boolean isAdsPermission() {
        return adsPermission;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
