package com.company;

public class Main {

    public static void main(String[] args) {
        int number = sum(9, 7);
        String name = "Niv";
	    boolean b = isMale(name);
        if (b == true){
            System.out.println(name + " is MALE");
        }else{
            System.out.println(name + " is FEMALE");
        }
    }

    public static boolean isMale(String str){
        //System.out.println(str);
        return false;
    }

    public static int sum(int x, int y){
        return x + y;
    }
}
