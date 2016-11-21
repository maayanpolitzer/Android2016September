package com.company;

/**
 * Created by hackeru on 11/21/2016.
 */
public class WorkerThread extends Thread {

    private Countdown c;

    public WorkerThread(Countdown countdown, String name){
        this.c = countdown;
        setName(name);
    }

    @Override
    public void run() {
        c.doCountdown();
    }
}
