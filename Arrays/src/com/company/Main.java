package com.company;

public class Main {

    public static void main(String[] args) {

        int size = 8;
        int i = 5;
        i = -407;

        int[] arr2 = new int[]{67,6,678,56,34,2,45,34,56,76,45,234};
        int[] arr = {-40, 406, 302,-6,-4,0,0,8};
        int[] test = {12, 14, 20};
        int[] grades = new int[size];
        grades[0] = 87; // change data in the array.

        //System.out.println(grades[3]); // get data from the array.
        //System.out.println("The size of grades array is: " + grades.length);

        //display(arr);
        //System.out.println(sum(grades));
        //System.out.println(max(test));
        //System.out.println(isNumberInArray(arr, 67));   // false;
        //System.out.println(isLastNumberPositive(arr));  // true;
        //System.out.println(sumOfOddsIndex(arr));    // return the sum of the odds index (1,3,5,7,9...) of the array.
        //System.out.println(numberTimesInArr(arr, 0));// return the number of times 67 appears in the array
        //int[] largeArray = multipleArr(test);   // return a new array with multiple every cell.
        //display(largeArray);
        //printArray(arr);  // prints the array like that: [-40, 406, 302, -6, -4, 0, 0, 8]
        //int[] reverseArr = revArr(arr);
        //printArray(reverseArr);
        System.out.println(maxDiff(arr));   // between the max number and min number
        //System.out.println(isOrdered(arr));   // returns true if the arr is ordered from min to max.
    }

    public static int maxDiff(int[] arr){
        return -1;
    }

    public static boolean isOrdered(int[] arr){
        return false;
    }

    public static int[] revArr(int[] arr){
        int temp = 0;
        int[] reverseArr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--){
            reverseArr[temp++] = arr[i];
        }
        return reverseArr;
    }

    public static void printArray(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if (i != arr.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int[] multipleArr(int[] arr){
        int[] largeArr = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++){
            largeArr[i * 2] = arr[i];
            largeArr[(i * 2) + 1] = arr[i];
        }
        /*
        int temp = 0;
        for (int i= 0; i < arr.length; i++){
            largeArr[temp++] = arr[i];
            largeArr[temp++] = arr[i];
        }
        */
        return largeArr;
    }

    public static int numberTimesInArr(int[] arr, int number){
        int counter = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == number){
                counter++;
            }
        }
        return counter;
    }

    public static int sumOfOddsIndex(int[] mateo){
        /*
        int sum = 0;
        for (int i = 0; i < mateo.length; i++){
            if (i % 2 != 0){
                sum += mateo[i];
            }
        }
        return sum;
        */
        int sum = mateo[1];
        for (int i = 3; i < mateo.length; i+=2){
            sum += mateo[i];
        }
        return sum;

    }

    public static boolean isLastNumberPositive(int[] mateo){
        int lastNumber = mateo[mateo.length - 1];
        if (lastNumber > 0){
            return true;
        }else {
            return false;
        }
        //return mateo[mateo.length - 1] > 0;
    }

    public static boolean isNumberInArray(int[] arr, int number){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == number){
                return true;
            }
        }
        return false;
    }

    public static int sum(int[] x){
        int result = 0;
        for (int i = 0; i < x.length; i++){
            result += x[i];
        }
        return result;
    }

    public static int max(int[] x){
        int mateo = x[0];
        for (int i = 1; i < x.length; i++){
            if (mateo < x[i]){
                mateo = x[i];
            }
        }
        return mateo;
    }

    public static void display(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
