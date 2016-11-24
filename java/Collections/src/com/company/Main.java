package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // array:
        int[] arr = new int[5];
        arr[2] = 39;    // change
        // no insert!
        // no remove!
        //System.out.println(arr.length); // get the size.
        /*
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        */
        for (int i : arr){
           // System.out.println(i);
        }
        // disadvantage: size already defined.
        // advantage: get primitive types!

        // arrayList:
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(45);    // insert
        arrList.add(232424);
        arrList.add(345);
        //System.out.println(arrList.size()); // get size.
        arrList.remove(1);  // remove by index.
        arrList.remove(new Integer(345));   // remove by value.
        arrList.set(0, 3457);
        //System.out.println(arrList);    // display.

        // LinkedList:

        LinkedList<String> ll = new LinkedList();
        ll.add("Maayan");
        ll.add("Aviv");
        ll.add("Mateo");
   //     System.out.println(ll);
//        System.out.println(ll.get(4));  // search disadvantage.
        // fast insert and remove.

        // Set:
        Collection<String> set = new LinkedHashSet<>();
        set.add("Moshe");
        set.add("Maayan");
        set.add("aviv");
        set.add("Kiril");
        set.add("aviv");    // deleted!
        //set.remove("Maayan"); // remove by value
        System.out.println(set);
        for (String str : set){
            System.out.println(str);
        }

        // map:

        Map<String, Integer> map = new HashMap<>();
        map.put("Maayan Politzer", 30);   // insert;
        map.put("Dudi", 23);
        map.put("Aviv", 23);
        map.put("Dudi", 52);
        map.remove("Dudi", 23);
        System.out.println(map.get("Maayan Politzer"));
        System.out.println(map);


        for (String str : map.keySet()){
            System.out.println(map.get(str));
        }




    }



}
