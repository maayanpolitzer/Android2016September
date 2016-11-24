package com.company;


public class Main {

    public static void main(String[] args) {
        char[] chars = {' ',' ',' ',' ','o',' ','w','o',' ',' ',' '};
        MyString myS = new MyString(chars);
        System.out.println(myS.length());  // returns int - array length;
        System.out.println(myS.indexOf('w'));  // returns int - the index of the first same char in the array.
        System.out.println(myS.sameCharCount('o'));    // returns int - the number of times that same char is in the array.
        System.out.println(myS.charAt(3)); // returns char that in position 3.
        System.out.println(myS.contains('g')); // returns boolean.
        MyString sub = myS.subString(6,9); // returns MyString object that contains "wor";
        sub.print();
        MyString sub2 = myS.subString(3);
        sub2.print();
        System.out.println(sub2.isEmpty()); // returns boolean -check the array length.
        char[] dummy  = {'r','l','d'};
        System.out.println(myS.equals(new MyString(dummy)));  // returns boolean if the two arrays are the same!
        System.out.println(myS.endsWith(myS));
        myS.replace(4, 'K');
        myS.print();
        myS.trim();
        myS.print();

        MyString wow = MyString.valueOf(new char[]{'w','o','w'});   // returns a new MyString object with char[] from parameters.
        wow.print();
        /*
        myS.toUpperCase();
        myS.toLowerCase();
        */
        /*
        split
         */
    }
}

