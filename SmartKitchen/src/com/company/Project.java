package com.company;

public class Project implements TaskCompletedListener {

    private String name;
    private Task[] tasks;
    private int taskInProgress = 0;

    public Project(String name, Task[] tasks){
        this.name = name;
        this.tasks = tasks;
    }

    public void start(){
        moveToNextTask();
    }

    @Override
    public void moveToNextTask(){
        if (taskInProgress < tasks.length) {
            tasks[taskInProgress++].startTask(this);
        }else{
            done();
        }
    }

    public void done(){
        System.out.println(name + " is ready!!!");
    }

}
