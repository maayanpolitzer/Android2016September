package com.company;

import java.util.Date;

/**
 * Created by hackeru on 11/17/2016.
 */
public class Student extends Person implements Detials {

    private String subject;



    public Student(String name, String subject) {
        super(name);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return getName() + ", " + subject;
    }

    @Override
    public void city() {

    }

    @Override
    public String getCity() {
        return null;
    }

    @Override
    public int numOfAddresses(String address) {
        return 0;
    }
}
