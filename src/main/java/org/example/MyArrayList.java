package org.example;

public class MyArrayList<E> {

    private E[] myArrayList;
    private int length;

    public MyArrayList() {
        length = 0;
        Object[] array = new Object[length];
        myArrayList = (E[]) array;
    }

    public void add(E value) {
        length++;
        myArrayList = changeSizeOfArray(myArrayList, length);
        myArrayList[myArrayList.length - 1] = value;
    }

    public void remove(int index) {
        for(int i = index; i < myArrayList.length - 1; i++) {
            myArrayList[i] = myArrayList[i + 1];
        }
        myArrayList = changeSizeOfArray(myArrayList, myArrayList.length - 1);
        length--;
    }

    public void clear() {
        length = 0;
        myArrayList = changeSizeOfArray(myArrayList, length);
    }

    public int size(){
        return length;
    }

    public E get(int index) {
        return myArrayList[index];
    }


    private E[] changeSizeOfArray(E[] oldArray, int newSize) {
        Object[] array = new Object[newSize];
        E[] newArray = (E[]) array;
        if (newSize > oldArray.length) {
            System.arraycopy(oldArray, 0, newArray, 0, newSize - 1);
        } else {
            System.arraycopy(oldArray, 0, newArray, 0, newSize);
        }
        return newArray;
    }
}
