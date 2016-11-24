package com.company;

import java.util.Date;

/**
 * Created by hackeru on 11/17/2016.
 */
public abstract class Person {

    private String name;

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void city();

}
