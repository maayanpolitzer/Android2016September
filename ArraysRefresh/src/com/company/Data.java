package com.company;

/**
 * Created by hackeru on 11/17/2016.
 */
public class Data {

    private String name;
    private int number;

    public Data(String name, int number){
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return name + "-" + number;
    }
}
