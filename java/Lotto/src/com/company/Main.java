package com.company;

import java.util.Random;

public class Main {

    static int[] myLotto = {1,2,3,4,5,6};        // 1-36.
    static int[] lotto = new int[6];
    static int myExtra = 7;         //1-8
    static int extra;
    static Random random = new Random();

    public static void main(String[] args) {
        createLottery();
        printArr(lotto);
        int guesses = checkResults();
        System.out.println("You guessed " + guesses + " numbers!!!");
        extra = generateNumber(8);
        boolean extraGuess = myExtra == extra;
        System.out.println("extra(" + extra + "): " + extraGuess);
    }

    public static int checkResults(){
        int counter = 0;
        for (int i = 0; i < myLotto.length; i++){
            for (int j = 0; j < lotto.length; j++){
                if (myLotto[i] == lotto[j]){
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }

    public static void printArr(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if (i < arr.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void createLottery(){
        for (int i = 0; i < lotto.length; i++){
            int number = generateNumber(6);
            if (isValid(number, i)) {
                lotto[i] = number;
            }else{
                i--;
                System.out.println("SAME NUMBER!!!");
            }
        }
    }



    public static boolean isValid(int number, int index){
        for (int i = 0; i < index; i++){
            if (lotto[i] == number){
                return false;
            }
        }
        return true;
    }

    /**
     * Method to generate a random number.
     * @param max int, the max number to generate ( zero is the MIN).
     * @return int random number.
     */
    public static int generateNumber(int max){
        return 1 + random.nextInt(max);
    }



}
