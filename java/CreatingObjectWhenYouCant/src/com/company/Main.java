package com.company;

public class Main {

    public static void main(String[] args) {

        Animal a = new Animal() {
            @Override
            public void sayHi() {
                System.out.println("Hi from anonymous class that extends animal");
            }
        };

        a.sayHi();

        Printable p = new Printable() {
            @Override
            public void print() {
                System.out.println("Printing.......");
            }
        };

        p.print();

    }
}
