package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println();

        //1 1 2 3 5 8 13 21 34 55 89
        System.out.println(fib(150));

    }

    static int fib(int n){
        if(n==1 || n==2)
            return 1;
        //return fib(n-1) + fib(n-2);
        int a = 0;
        int b = 1;
        int c;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }


    static void bubbleSort(int[] arr){
        int upTo = arr.length-1;
        boolean isSorted = false;
        while(!isSorted){
            isSorted = true;
            for (int i = 0; i < upTo; i++) {
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    isSorted = false;
                }
            }
            upTo--;
        }
    }

    //

    static void merge(int[] arr, int l, int m, int r){

        int n1 = m-l+1;
        int n2 = r-m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int i = 0; i < n2; i++) {
            R[i] = arr[m + 1 + i];
        }
        int i=0, j=0;
        int k = l;
        while(i<n1 && j<n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }

    }


    static void mergeSort(int[] arr, int l, int r){
        if(l<r){
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    //low 5 high 12
    static int randomizedPartition(int[] arr, int low, int high){
        int now = (int)System.currentTimeMillis();

        Random random = new Random(now);
        int pos = random.nextInt(high-low)+low;
        int temp = arr[high];
        arr[high] = arr[pos];
        arr[pos] = temp;
        return partition(arr, low, high);
    }

    static boolean containsPairWithSum(int[] arr, int sum){

        boolean[] map = new boolean[1000];
        for (int i = 0; i < arr.length; i++) {
            int temp = sum - arr[i];
            if(temp>=0 && map[temp]){
                return true;
            }
            map[arr[i]] = true;
        }
        return false;
        /*
        quickSort(arr, 0, arr.length-1);

        int l = 0, r = arr.length-1;
        while(l<r){
            if(arr[l] + arr[r] == sum)
                return true;
            else if(arr[l] + arr[r] < sum)
                l++;
            else
                r--;
        }
        return false;
        */
    }

    static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high ; j++) {
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }


    static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }


    static int distance(int x, int y) {
        /*int result = x - y;
        if (result < 0)
            result *= -1;
        return result;*/
        int small = x;
        int large = y;
        if(x>y){
            small = y;
            large = x;
        }
        int result = 0;
        while(small + result < large)
            result++;
        return result;
    }

    /*static int product(int x, int y){
        int small = x;
        int large = y;
        if(x>y){
            small = y;
            large = x;
        }

        int result = 0;
        for (int i = 0; i < small; i++) {
            result += large;
        }
        return result;
    }*/

    static int product(int x, int y){
        int result = 0;
        int counter = 0;
        while (y > 0){
            counter++;
            if(y%2==0){
                y = y >> 1; //y /= 2;
                x = x << 1; //x *= 2;
            }else{
                y--;
                result += x;
            }
        }
        System.out.println(counter);
        return result;
    }

    static int quotient(int x, int y) throws DivisionByZeroException{
        if(y==0)
            throw new DivisionByZeroException();
        int result = 0;
        int sum = y;
        while(sum<=x){
            sum += y;
            result++;
        }
        return result;
    }
    //sum    3   6   9
    //result 0   1   2


    static int remainder(int x, int y) throws DivisionByZeroException {
        if(y==0)
            throw new DivisionByZeroException();
        return distance(product(quotient(x, y), y), x);
    }

    static DivisionResult division(int x, int y) throws DivisionByZeroException {
        if(y==0)
            throw new DivisionByZeroException();
        int result = 0;
        int sum = y;
        int largestProductOfY = 0;
        while(sum<=x){
            sum += y;
            largestProductOfY += y;
            result++;
        }
        return new DivisionResult(result, distance(x, largestProductOfY));
    }

    /*static int power(int x, int y){
        if(x == 0){
            if(y == 0)
                return -1;
            return 0;
        }
        if(y==0 || x==1)
            return 1;
        int result = x;
        for (int i = 1; i < y; i++) {
            result *= x;
        }
        return result;
    }*/

    /*
    static int power(int x, int y){
        if(x == 0){
            if(y == 0)
                return -1;
            return 0;
        }
        if(y==0 || x==1)
            return 1;
        return power(x, y-1) * x;
    }
    */

    static int power(int x, int y){
        if(x == 0){
            if(y == 0)
                return -1;
            return 0;
        }
        if(y==0 || x==1)
            return 1;

        if(y%2==0){
            int temp = power(x, y/2);
            return temp * temp;
        }else{
            int temp = power(x, (y-1)/2);
            return temp * temp * x;
        }
    }


}


class DivisionByZeroException extends Exception{

}

class DivisionResult{
    int times;
    int remainder;

    public DivisionResult(int times, int remainder) {
        this.times = times;
        this.remainder = remainder;
    }
}





class LinkedList<T>{

    private Node anchor;

    public LinkedList(){
        anchor = new Node(123);
    }


    public void add(T value){
        Node last = anchor;
        while(last.next != null)
            last = last.next;
        last.next = new Node(value);
    }

    public void addAT(T value, int index){
        Node last = anchor;
        int counter = 0;
        while(last.next != null && counter < index) {
            last = last.next;
            counter++;
        }
        Node temp = last.next;
        last.next = new Node(value);
        last.next.next = temp;
    }

    public T get(int index){
        Node node = anchor;
        int counter = -1;
        while(node.next != null && counter < index) {
            node = node.next;
            counter++;
        }
        if(counter != index)
            throw new IndexOutOfBoundsException();
        return (T)node.value;
    }

    static class Node<T>{
        T value;
        Node next;

        public Node(T value){
            this.value = value;
        }

    }


}


class ArrayList<T>{

    private T[] arr;
    int size;

    public ArrayList(){
        arr = (T[])new Object[10];
        size = 0;
    }

    public void add(T value){
        makeRoom();
        arr[size++] = value;
    }

    public void addAt(T value, int index){
        makeRoom();
        for (int i = size; i > index; i--) {
            arr[i] = arr[i-1];
        }
        arr[index] = value;
    }
    public T get(int index){
        if(index>=size || index < 0)
            throw new IndexOutOfBoundsException();
        return arr[index];
    }

    private void makeRoom(){
        if(size == arr.length){
            T[] temp = (T[]) new Object[arr.length * 2];
            for (int i = 0; i < size; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
    }

}






