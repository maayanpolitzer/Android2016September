package com.company;


/**
 * Created by hackeru on 10/6/2016.
 */
public class MyArray {

    private String[] names;
    private int counter;    // default is 0;

    public MyArray() {
        names = new String[10];
    }

    public void add(String name) {
        if (counter >= names.length) {
            makeRoom();
        }
        names[counter++] = name;
    }

    public void add(int index, String str){
        if (index < 0 || index > counter){
            throw new IndexOutOfBoundsException();  // like return; but with exception.
        }
        if (counter == names.length){
            makeRoom();
        }
        for (int i = counter; i > index; i--){
            names[i] = names[i-1];
        }
        names[index] = str;
        counter++;
    }

    public int size(){
        return counter;
    }

    public String get(int index){
        if (index < counter){
            return names[index];
        }
        throw new IndexOutOfBoundsException("there is no index like that in the array...:(");
    }

    public boolean contains(String c){
        for (int i = 0; i < counter; i++){
            if (c == names[i]){
                return true;
            }
        }
        return false;
    }

    private void makeRoom() {
        String[] tempArr = new String[counter * 2];
        for (int i = 0; i < names.length; i++) {
            tempArr[i] = names[i];
        }
        names = tempArr;
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < counter - 1; i++) {
            System.out.print(names[i] + ", ");
        }
        System.out.println(names[counter - 1] + "]");
    }

}
