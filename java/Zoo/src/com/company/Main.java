package com.company;

import java.util.Random;

public class Main {

    public static Animal[] animals = {
            new Animal("Lion", false, true),
            new Animal("T-rex", false, true),
            new Animal("Dolphin", true, true),
            new Animal("Shark", true, true),
            new Animal("Gold fish", true, false),
            new Animal("monkey", false, false)
    };

    public static void main(String[] args) {

        Zoo ramatGan = new Zoo("Ramat gan national zoo", "Maayan Politzer", 2, 2);


        /*
        System.out.println(ramatGan.getManager());
        ramatGan.setManager("Mateo");
        System.out.println(ramatGan.getManager());
        System.out.println(ramatGan.getNumOfAnimals());
        */

        /*
        Animal shark = new Animal("Shark", true, true);
        for (int i = 0; i < 3; i++) {
            ramatGan.addAnimalToCage(shark);
        }
        */

        for (int i = 0; i < 150; i++){
            ramatGan.addAnimalToCage(animals[generateRandomNumber()]);
        }

        ramatGan.printCages();
    }

    public static int generateRandomNumber(){
        Random random = new Random();
        return random.nextInt(animals.length);
    }


}
