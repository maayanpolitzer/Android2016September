package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Person> list = new ArrayList<>();

        list.add(new Teacher());
        list.add(new Teacher());
        list.add(new SportTeacher());
        list.add(new Cleaner());
        list.add(new Manager());
        list.add(new EconomicsStudent());

        for (int i = 0; i < list.size(); i++){
            if(list.get(i) instanceof Teacher) {
                /*
                Teacher t = (Teacher) list.get(i);
                t.getClassRoom();
                */
                ((Teacher) list.get(i)).getClassRoom();
            }

        }

        for (int i = 0; i < list.size(); i++){
            if(list.get(i) instanceof GuestToMeetings) {
                /*
                GuestToMeetings g = (GuestToMeetings) list.get(i);
                g.budgetMeeting();
                */
                ((GuestToMeetings) list.get(i)).budgetMeeting();
            }

        }

        Employee e = new Teacher();
        Teacher t = (Teacher) e;



        int i = 10;   // int has 4 bytes
        short s = (short) i;    // short has 2 bytes - casting.



/*
        Teacher[] teachers = new Teacher[2];

        teachers[0] = new Teacher();
        teachers[1] = new Teacher();

        for (int i = 0; i < teachers.length; i++){
            teachers[i].getClassRoom();
        }
*/
    }
}
