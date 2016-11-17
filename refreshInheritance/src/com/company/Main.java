package com.company;

import java.util.Date;

public class Main {

    static Person[] humans = new Person[3];

    public static void main(String[] args) {

        Date dob = new Date(1986, 5, 16);
        Person p1 = new Student("Maayan", "android");

        //cast to student.
        Student s6 = (Student) p1;
        s6.getSubject();

        System.out.println(p1);

        Student s1 = new Student("Maayan2", "java");
        System.out.println(s1.toString());


        humans[0] = p1;
        humans[1] = s1;

        /*
        for (int i = 0; i < humans.length; i++){
           // humans[i].getSubject();
            if(humans[i] instanceof Student) {
                Student temp = (Student) humans[i];
                System.out.println(temp.getSubject());
            }
        }
        */

        for(Person temp : humans){
            if (temp instanceof Student){
                Student s = (Student) temp;
                System.out.println(s.getSubject());
            }
        }
    }
}
