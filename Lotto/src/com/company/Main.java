package com.company;

import java.util.Random;

public class Main {

    static int[] myLotto = {5,6,2,15,34,34};        // 1-36.
    static int[] lotto = new int[6];
    static int myExtra = 3;
    static int extra;

    public static void main(String[] args) {

      // Math.sqrt();

        random();

    }

    public static void random(){
        Random random = new Random();
        int number = random.nextInt(5);        // 0-5
        System.out.println(number);
        /*
        for (int i = 0; i < lotto.length; i++){

        }
        */
    }


}
