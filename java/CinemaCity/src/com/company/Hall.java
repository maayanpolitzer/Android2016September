package com.company;

/**
 * Created by Hackeru on 10/13/2016.
 */
public class Hall {

    private String movieName;
    private boolean[] seats;        // false - available, true - taken.

    public Hall(String movieName, int numOfSeats){
        this.movieName = movieName;
        seats = new boolean[numOfSeats];
    }

    public int buyTicket(){
        for(int i = 0; i < seats.length; i++){
            if (!seats[i]){ // same as if(seats[i] == false){
                seats[i] = true;
                return i;
            }
        }
        return -1;
    }

    public boolean buyTicket(int position){
        if(position >= 0 && position < seats.length){
            if(!seats[position]){
                seats[position] = true;
                return true;
            }
            return false;
        }
        throw new IndexOutOfBoundsException("Position does not exists.");
    }

    public void print(){
        System.out.print(movieName + ":");
        for (int i = 0; i < seats.length; i++){
            System.out.print(seats[i] ? "X" : "-");
            /*
            if (seats[i]){
                System.out.print("X");
            }else{
                System.out.print("-");
            }
            */
        }
        System.out.println();
    }
/*
    public boolean cancelTicket(int position){

    }

    public boolean isFull(){    // return true if this hall is full.

    }

    public int buyManyTickets(int numOfTickets){

    }

*/

}
