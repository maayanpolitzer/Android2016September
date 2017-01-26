package com.example.hackeru.advancedfragments;

import java.io.Serializable;

/**
 * Created by hackeru on 1/26/2017.
 */

public class Monster implements Serializable {

    private String name;
    private int age;
    private int image;

    public Monster(String name, int age, int image) {
        this.name = name;
        this.age = age;
        this.image = image;
    }

    @Override
    public String toString() {
        return name + ", " + age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getImage() {
        return image;
    }



}
