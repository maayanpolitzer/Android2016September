package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static CinemaCity glilot = new CinemaCity();

    public static void main(String[] args) {
        firstQuestion();
    }

    private static void firstQuestion() {
        System.out.println("Manager (m) OR Cashier (c)?");
        String employee = scanner.nextLine();

        if (employee.equals("m")){
            managerMenu();
        }else if(employee.equals("c")){
            System.out.println("You are cashier");
        }else{
            System.out.println("Whattttt?????????");
        }
    }

    private static void managerMenu(){
        System.out.println("Hi manager, what do you want to do?");
        System.out.println("Add hall (a), view halls status and price (b), switch movie(c), set price (e), MONEY MONEY MONEY (f)?");
        String action = scanner.nextLine();
        switch(action){
            case "a":
                glilot.addHall(new Hall("Spy", 16));
                break;
            case "b":
                // loop the halls, call the print method.
                System.out.println("Ticket price is: " + glilot.getPrice());
                break;
            case "c":
                glilot.getHall(0).setMovieName("Titanic");
                break;
            case "e":
                System.out.println("What is the new price?");
                String price = scanner.nextLine();
                glilot.setPrice(Integer.parseInt(price));
                break;
            case "f":
                // loop all the halls check how many ticket were bought * price
                break;
            case "EXIT":
                return;
            default:

        }
        managerMenu();
    }
}
