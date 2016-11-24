package com.company;

public class Main {

    public static void main(String[] args) {

        Countdown c = new Countdown();

        WorkerThread t1 = new WorkerThread(c, "** first **");

        WorkerThread t2 = new WorkerThread(c, "-- second --");

        t1.start();
        t2.start();

    }
}
