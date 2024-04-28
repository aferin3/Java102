package com.homework.GenericList;

import java.util.Arrays;

public class MyList<T> {
    public T[] array;
    int counter = 0;

    public MyList() {

        this.array = (T[]) new Object[10];

    }

    public MyList(int capacity) {

        this.array = (T[]) new Object[capacity];

    }

    int lastIndexOf(T data){
        for (int i = array.length-1;i>=0 ; i--){
            if(array[i] == data){
                return i;
            }
        }return -1;


    }

    boolean contains(T data){
        if(indexOf(data) == -1) return false;
        else return true;
    }

    MyList<T> subList(int start, int finish){

        MyList<T> sList = new MyList<>(finish-start+1);

        for(int i = start, j=0;i<sList.getArray().length;i++,j++){
            sList.getArray()[j]=array[i];
        }
        return sList;

    }

    void clear(){
        this.array = (T[]) new Object[array.length];
    }

    T[] toArray(){
        T[] object =(T[]) new Object[size()];

        for (int i = 0; i < size(); i++) {
            object[i] = array[i];
        }

        return object;

    }

    int indexOf(T data){
        for(int i = 0; i<array.length ; i++){
            if(array[i] == data){
                return i;
            }
        }
        return -1;
    }
    Boolean isEmpty(){
        if(size() == 0) return false;
        else return true;
    }

    public String toString() {
        
        return Arrays.toString(toArray());

    }

    Boolean set(int index, T data) {
        if (index > array.length - 1 || index < 0) {
            return null;
        } else {
            this.array[index] = data;
            return true;
        }

    }

    Object get(int index) {
        if (index > array.length - 1 || index < 0) {
            return null;
        } else {
            return array[index];
        }
    }

    Object remove(int index) {

        if (index > array.length - 1 || index < 0) {
            return null;
        } else {
            // Object o =array[index];
            array[index] = null;
            for (int i = index; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            counter--;

            return array;
        }

    }

    int getCapacity() {

        return this.array.length;
    }

    void add(T data) {
        if (counter >= this.array.length) {
            this.array = Arrays.copyOf(array, counter * 2);
        }
        this.array[counter] = data;
        // System.out.println(this.array[counter]);
        counter++;
    }

    int size() {
        int x = 0;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != null) {
                x++;
            }
        }
        return x;
    }

    Object[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

}
