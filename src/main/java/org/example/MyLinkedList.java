package org.example;

import org.w3c.dom.Node;

import java.util.LinkedList;

public class MyLinkedList<E> {
    private MyNode first;
    private MyNode last;
    private int length;

    public MyLinkedList() {
        this.first = null;
        this.last = null;
    }
    public void add(E value) {
        MyNode prev = last;
        MyNode node = new MyNode(prev, value, null);
        last = node;
        if(prev == null) {
            first = node;
        } else {
            prev.next = node;
        }
        length++;
    }

    public void remove(int index) {
        if(index >= length || index < 0) {
            System.out.println("The index you have entered is invalid");
            return;
        }
        MyNode element = first;
        for(int i = 0; i < length; i++) {
            if(i == index) {
                if(element.prev == null) {
                    element.next.prev = null;
                    first = element.next;
                    break;
                }
                if(element.next == null) {
                    element.prev.next = null;
                    last = element.prev;
                    break;
                }
                element.prev.next = element.next;
                element.next.prev = element.prev;
                break;
            }
            element = element.next;
        }
        element = null;
        length--;
    }

    public void clear() {
        MyNode element = first;
        for (int i = 0; i < length; i++) {
            MyNode next = element.next;
            element.next = null;
            element.prev = null;
            element.item = null;
            next = element;
        }
        first = null;
        last = null;
        length = 0;
    }

    public int size() {
        return length;
    }

    public E get(int index) {
        if(index >= length || index < 0) {
            System.out.println("The index you have entered is invalid");
            return null;
        }
        MyNode element = first;
        for(int i = 0; i < length; i++) {
            if(i == index) {
                break;
            }
            element = element.next;
        }
        return (E) element.item;
    }
}
