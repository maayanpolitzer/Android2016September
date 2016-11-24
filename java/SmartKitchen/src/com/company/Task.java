package com.company;

/**
 * Created by hackeru on 10/31/2016.
 */

public class Task {

    private String name;
    private int time;
    private TaskCompletedListener listener;

    private static final int SECOND = 1000;

    public Task(String name, int time){
        this.name = name;
        this.time = time;
    }

    public void startTask(TaskCompletedListener listener){
        this.listener = listener;
        System.out.println("starting " + name);
        try {
            Thread.sleep(time * SECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        completeTask();
    }

    private void completeTask(){
        System.out.println(name + " is complete");
        listener.moveToNextTask();
    }

}
