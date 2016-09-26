package com.company;

public class Main {

    public static void main(String[] args) {

        //System.out.println(distance(8,8));        //  4;
        //System.out.println(product(40000000,6));  //  24;
        //System.out.println(quatient(10,3));       //  3;
        //System.out.println(remainder(10,3));      //  1;
        System.out.println(power(9,0));           //  256;
        //System.out.println(sqrt(50));             //  7;
    }

    public static int sqrt(int x){
        return 3;
    }

    public static int power(int x, int y){
        if (y == 0){
            return 1;
        }
        if (x == 0){
            return 0;
        }
        int result = x;
        for (int i = 1; i < y; i++){
            result = product(result, x);
        }
        return result;
    }



    public static int remainder(int x, int y){
        return distance(x,product(quatient(x,y), y));
    }

    public static int quatient(int x, int y){
        if (x < y){
            return 0;
        }
        if (x == y){
            return 1;
        }
        if (y == 0){
            return -1;
        }
        int counter = 0;
        int helper = y;
        while(helper <= x){
            helper += y;
            counter++;
        }
        return counter;
    }

    public static int product(int x, int y){
        if (x == 0 || y == 0){
            return 0;
        }
        int counter = 0;
        int small = x;
        int large = y;
        if (x > y){
            small = y;
            large = x;
        }
        for (int i = 0; i < small; i++){
            counter += large;
        }
        return counter;
    }

    public static int distance(int x, int y){
        if (x == y){
            return 0;
        }
        int counter = 0;
        int small = x;
        int large = y;
        if (x > y){
            small = y;
            large = x;
        }
        while (small + counter < large){
            counter++;
        }
        /*
        for (int i = small; small + counter < large; i++){
            counter++;
        }
        */
        return counter;
    }

}
