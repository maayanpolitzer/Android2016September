package com.company;

/**
 * Created by hackeru on 10/27/2016.
 */
public class Student extends Person {

    private String university;

    public Student(String name, boolean male, int age, double weight, double height, String university){
        super(name, male, age, weight, height);
        this.university = university;
    }

    public Student(String name, int age, double weight, double height){
        super(name, true, age, weight, height);
        university = "Moshe's campus...";
    }

    @Override
    public String toString() {
        return super.toString() + ", " + university;
    }

    public String getUniversity() {
        return university;
    }
}
