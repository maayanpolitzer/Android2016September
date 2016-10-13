package com.company;

/**
 * Created by hackeru on 10/10/2016.
 */
public class MyString {

    private char[] chars;

    public MyString(char[] chars){
        this.chars = chars;
    }

    public MyString(byte[] bytes){
        this(bytes, 0, bytes.length);   // use your constructor!!!
        /*
        chars = new char[bytes.length];
        for (int i = 0; i < chars.length; i++){
            chars[i] = (char) bytes[i];
        }
        */
    }

    public MyString(byte[] bytes, int offset, int length){
        if (offset >= 0 && offset < bytes.length && length >= 0 && length + offset <= bytes.length) {
            chars = new char[length];
            for (int i = 0; i < chars.length; i++){
                chars[i] = (char) bytes[i + offset];
            }
        }
    }

    public int length(){
        return chars.length;
    }

    public boolean contains(char c){
        return indexOf(c) != -1;
    }

    public void replace(int index, char c){
        if(index >= 0 && index < chars.length){
            chars[index] = c;
        }
    }

    public int indexOf(char c){
        for(int i = 0; i < chars.length; i++){
            if (chars[i] == c){
                return i;
            }
        }
        return -1;
    }

    public void print(){
        for (int i = 0; i < chars.length; i++){
            System.out.print(chars[i]);
        }
        System.out.println();
    }

    public MyString subString(int start, int end){
        if (start >= 0 && start <= chars.length && end <= chars.length && end >= start){
            char[] tempArr = new char[end-start];
            for(int i = start; i < end; i++){
                tempArr[i - start] = chars[i];
            }
            return new MyString(tempArr);
        }
        throw new IndexOutOfBoundsException("Why like this???? :(");
    }

    public boolean isEmpty(){
        return chars.length == 0;
    }

    public MyString subString(int start){
        return subString(start, chars.length);
    }

    public boolean equals(MyString obj){
        if(obj.length() != chars.length){
            return false;
        }
        for (int i = 0; i < chars.length; i++){
            if (chars[i] != obj.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public int sameCharCount(char c){
        int counter = 0;
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == c){
                counter++;
            }
        }
        return counter;
    }

    public boolean endsWith(MyString obj){
        if (obj.length() > 0 && obj.length() <= chars.length){
            int counter = 1;
            for (int i = obj.length() - 1; i >= 0; i--){
                if (obj.charAt(i) != chars[chars.length - (counter++)]){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public char charAt(int index){
        if (index < 0 || index >= chars.length){
            throw new IndexOutOfBoundsException("WTF???");
        }
        return chars[index];
    }

    public void trim(){
        int start = 0;
        int end = 0;
        for (int i = 0; i < chars.length; i++){
            if (chars[i] != ' '){
                start = i;
                break;
            }
        }
        for (int i = chars.length - 1; i > start; i--){
            if (chars[i] != ' '){
                end = i;
                break;
            }
        }
        MyString temp = subString(start, end+1);
        chars = temp.chars;
    }

    public static MyString valueOf(char[] arr){
        return new MyString(arr);
    }

    public void toUpperCase(){
        for (int i = 0; i < chars.length; i++){
            int b = chars[i];
            if (b >= 97 && b <= 122){
                b -= 32;
                chars[i] = (char) b;
            }
        }
    }

    public void toLowerCase(){
        for (int i = 0; i < chars.length; i++){
            if (chars[i] >= 65 && chars[i] <= 90){
                chars[i] += 32;
            }
        }
    }

    public byte[] getBytes(){
        byte[] bytes = new byte[chars.length];
        for (int i = 0; i < chars.length; i++){
            bytes[i] = (byte) chars[i];
        }
        return bytes;
    }

}
