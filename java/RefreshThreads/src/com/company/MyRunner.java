package com.company;

/**
 * Created by hackeru on 11/21/2016.
 */
public class MyRunner implements Runnable {

    private int number;
    private String name;

    public MyRunner(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.print("Run by : " + Thread.currentThread().getName());
        System.out.println(" name: " + name + ", number: " + number);
    }

    public void setName(String name) {
        this.name = name;
    }


}
