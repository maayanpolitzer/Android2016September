package com.company;

public class Main {

    public static void main(String[] args) {

        // 1. create a class that extend Thread class, and override the run() method.
        MyThread t1 = new MyThread();
        t1.setName("Thread 1");
        t1.setPriority(10);
        //t1.run();   // calling run() NOT GOOD!!! runs in mainThread.
        t1.start();   // will call run() method in a new thread.


        // 2.0. create a class that implements Runnable interface, and implement run() method.
        // 2.1. create an Object from Thread class and pass to the constructor the runnable object.
        // 2.2. call the start() method.
        MyRunner r1 = new MyRunner(20, "Moshe");
        Thread t2 = new Thread(r1);
        t2.setName("Thread 2");
        t2.start();
        r1.setName("Menachem");


        // 3. quick way... anonymous Runnable class.
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                    System.out.println("T1 ended...");
                    System.out.println("Hello from anonymous thread...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        System.out.println("Main method is DONE!!!");

    }
}
