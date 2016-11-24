package com.company;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        char[] c = {'H','e','l','l','o',' ','w','o','r','l','d'};
        MyString my = new MyString(c);
        System.out.println(my.length());  // returns int - array length;
        System.out.println(my.indexOf('w'));  // returns int - the index of the first same char in the array.
        System.out.println(my.sameCharCount('o'));    // returns int - the number of times that same char is in the array.
        System.out.println(my.charAt(3)); // returns char that in position 3.
        System.out.println(my.contains('g')); // returns boolean.
        MyString sub = my.subString(6,9); // returns MyString object that contains "wor";
        sub.print();
        MyString sub2 = my.subString(3);
        sub2.print();
        System.out.println(sub2.isEmpty()); // returns boolean -check the array length.
        char[] dummy  = {'r','l','d'};
        System.out.println(my.equals(new MyString(dummy)));  // returns boolean if the two arrays are the same!
        System.out.println(my.endsWith(my));
        my.replace(4, 'K');
        my.print();
        my.trim();
        my.print();

        MyString wow = MyString.valueOf(new char[]{'w','o','w'});   // returns a new MyString object with char[] from parameters.
        wow.print();
        //my.toUpperCase();
        my.toLowerCase();
        my.print();
        byte[] bytes = my.getBytes();   // return a new byte array with the chars values as numbers.
        MyString m2 = new MyString(bytes);  // create a constructor, create a char[], copy the byte value (char) to the new array.
        m2.print();
        /* Home work.
        split
         */
        MyString m3 = new MyString(bytes, 2, 6);
        m3.print(); // "llk wo"



    }
}

