package com.company;

/**
 * Created by hackeru on 11/3/2016.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++){
            System.out.println("---------------------- SECOND THREAD " + i + " -----------------------");
        }
    }
}
