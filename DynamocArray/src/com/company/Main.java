package com.company;

public class Main {

    public static void main(String[] args) {

        MyArray arr = new MyArray();
        arr.add("Aviv");
        arr.add("Mateo");
        arr.add("Daniel");
        arr.add("Moshe");
        arr.print();
        System.out.println(arr.size()); //  4;
        System.out.println(arr.contains("aviv"));   // false.
        System.out.println(arr.get(2));
        arr.add(2, "Mika"); // overload: two methods with the same name but different params (order/count).
        arr.add(0, "Liri");
        arr.print();
        arr.clear();    // initialize the array.
        arr.remove(3);  // returns boolean
        arr.remove("Mika"); // returns boolean removes the first!!!
        arr.isEmpty();  // returns boolean if there are values in the array.
        arr.set(4, "Irit"); // changes the value to Irit in arr[4];

    }
}
