package com.company;


public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after 5 seconds run() by : " + currentThread().getName());
    }
}
