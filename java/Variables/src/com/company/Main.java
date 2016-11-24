package com.company;

public class Main {

    //static int result;  // default is 0;
    /*
    static boolean b;   // default is false;
    static String name; // default is null;
    */
    //static int firstNumber = 6;
    //static int secontNumber = 7;

    static int a = 1;
    static int b = 2;

    public static void main(String[] args) {
        /*
        sum();
        System.out.println("Result is: " + result);
        */

        /*
        mysteryMix(a,a);
        mysteryMix(a,b);
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        */

        int i = 0;
        int n = 0;
        while(n < 90){
            for (i = 0; i < 10; i++){
                n += 3;
                if (n > 50){
                    break;
                }
            }
            n++;
        }
        System.out.println("n is: " + n);

        /*
        a. 51;
        b. 61;
        c. 91;
        d. 93;
        e. 104;

         */


    }

    /*
    public static void mysteryMix(int a, int b){

    }
    */

    /*
    public static void sum(){
        result = firstNumber + secontNumber;     // local variable.

    }

    public static void reset(){
        result = 0;
    }
    */



}
