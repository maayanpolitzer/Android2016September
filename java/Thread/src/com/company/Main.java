package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println("hi");
        System.out.println("wow");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("bye");

        /*
        1. extend the Thread class.

        MyThread t1 = new MyThread();
        t1.start();
        */

        /*
        2. implement the Runnable interface.

        Thread t2 = new Thread(new MyRunner());
        t2.start();
        */
        /*
        3. quick way...


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++){
                    System.out.println("------- SECOND THREAD " + i + " -------------");
                }
            }
        }).start();
        */
    }
}
