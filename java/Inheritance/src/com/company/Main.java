package com.company;

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student("Maayan", 30, 97, 1.92);
        System.out.println(s1);
        s1.sayHi();

        final Person p1 = new Person("maayan", true, 10, 4,4);
        System.out.println(p1);
        p1.setAge(44);
        System.out.println(p1);

    }
}
