package org.example;

public class MyStack<E> {
    private MyNode first;
    private MyNode last;
    private int length;

    public MyStack() {
        this.first = null;
        this.last = null;
    }

    public void push(E value) {
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

    public void remove(int index) {
        MyNode element = last;
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

    public int size() {
        return length;
    }

    public E peek() {
        return (E) last.item;
    }

    public E pop() {
        E result;
        MyNode element = last;
        result = (E) last.item;
        last = element.prev;
        if(element.prev == null) {
            clear();
        } else {
            element.prev.next = null;
            element = null;
            length--;
        }
        return result;
    }
}
