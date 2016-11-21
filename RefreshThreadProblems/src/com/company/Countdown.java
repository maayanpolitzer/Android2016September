package com.company;

/**
 * Created by hackeru on 11/21/2016.
 */
public class Countdown {

    private int i;

    public void doCountdown(){
        System.out.println("start");
        synchronized (this) {
            for (i = 10; i > 0; i--) {
                System.out.println(Thread.currentThread().getName() + ", i = " + i);
            }
        }
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " working... i = " + i);
        }
    }
}











