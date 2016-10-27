package com.company;

/**
 * Created by hackeru on 10/27/2016.
 */
public class Animal {

    private String name;
    private boolean aquatic;
    private boolean predator;

    public Animal(String name, boolean aquatic, boolean predator) {
        this.name = name;
        this.aquatic = aquatic;
        this.predator = predator;
    }

    public String getName() {
        return name;
    }


    public boolean isAquatic() {
        return aquatic;
    }

    public boolean isPredator() {
        return predator;
    }
}
