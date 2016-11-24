package com.company;

/**
 * Created by hackeru on 11/3/2016.
 */
public abstract class Animal {
    
    private String name;
    private int animalID;
    private Gender gender;
    private static int counter = 0;



    public Animal(String name, Gender gender){
        this.name = name;
        animalID = ++counter;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return name + ", " + gender;

    }

    public int getAnimalID() {
        return animalID;
    }
}
