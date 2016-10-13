package com.company;

public class Main {

    public static void main(String[] args) {

        int sum = 8+8;
        String s = sum + "";
        //System.out.println(s);

        // convert upward:
        byte b = 72;
        short s2 = b;
        int i2 = b;
        long l2 = i2;

        //convert downward:
        // casting...
        int i = 33000;
        short s3 = (short) i;
        System.out.println(s3);
        short s4 = sum(40,6);

        //long j = 500000000000000L;
        //float f =435.356345f;
        String j2 = 50 + "";
        System.out.println(j2);

        //helper class.
        long l = 234345345234L;
        Long longObject = new Long(l);
        short s5 = longObject.shortValue();
        System.out.println("short: " + s5);
        short s6 = (short) l;
        System.out.println("short by casting: " + s6);

        String age = "50";
        int g = Integer.parseInt(age);  // return primitive int.
        int g2 = Integer.valueOf(age);  // return Integer object.
        System.out.println("You have : " + (120-g) + " years left...");

        char c = 'a';
        int c2 = c + 10;
        char newC = (char) c2;
        System.out.println(newC);
    }

    public static short sum(int x, int y){
        int sum = x + y;
        return (short)sum;
    }
}
