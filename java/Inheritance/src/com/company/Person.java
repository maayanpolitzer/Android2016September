package com.company;

/**
 * Created by hackeru on 10/27/2016.
 */
public class Person {

    private String name;
    private boolean male;
    private int age;
    private double weight;
    private double height;

    public Person(String name, boolean male, int age, double weight, double height){
        this.name = name;
        this.male = male;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public void sayHi(){
        System.out.println("Hi man it's " + name);
    }


    @Override
    public String toString() {
        return name + ", " + male + ", " + age + ", " + weight + ", " + height;
    }


    public String getName() {
        return name;
    }

    public boolean isMale() {
        return male;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }
}
