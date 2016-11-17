package com.company;


import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        /*
        int[] arr = new int[4];

        arr[0] = 6;
        arr[1] = -4;
        arr[2] = 23;
        arr[3] = -76;

        int[] arr2 = {6,-4,23,-76};

        int[] arr3 = new int[]{6,-4,23,-76};

        System.out.println(arr2[2]);
        arr2[2] += 4;
        System.out.println(arr2[2]);

        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        */

        ArrayList<Data> numbers = new ArrayList<>();
        for (int i = 0; i < 3000; i++) {
            numbers.add(new Data("myName" + i, i * 76));
        }
        System.out.println(numbers.size());
        System.out.println(numbers);

        System.out.println(numbers.get(4));

        int[][] arr = new int[4][2];
        arr = new int[][]{{17,-4},{0,300},{40,-80},{510,7}};
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println();
        }

    }


}
