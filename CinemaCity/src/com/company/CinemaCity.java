package com.company;

import java.util.ArrayList;

/**
 * Created by Hackeru on 10/13/2016.
 */
public class CinemaCity {

    private int price;
    private ArrayList<Hall> halls;

    public CinemaCity(){
        halls = new ArrayList<>();
    }

    public void addHall(Hall newHall){
        halls.add(newHall);
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

}
