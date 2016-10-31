package com.company;

/**
 * Created by hackeru on 10/31/2016.
 */
public class Manager extends Employee implements GuestToMeetings {

    @Override
    public void budgetMeeting() {
        System.out.println("front");
    }
}
