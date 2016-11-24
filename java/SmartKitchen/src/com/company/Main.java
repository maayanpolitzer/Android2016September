package com.company;

public class Main {

    public static void main(String[] args) {

        Task[] tasks = new Task[3];
        tasks[0] = new Task("Malit", 5);
        tasks[1] = new Task("Dough", 3);
        tasks[2] = new Task("Bake", 4);

        Project quicheProject = new Project("Quiche", tasks);
        quicheProject.start();

    }
}
