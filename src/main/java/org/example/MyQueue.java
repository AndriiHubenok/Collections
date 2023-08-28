package org.example;

public class MyQueue<E> {
    private MyNode first;
    private MyNode last;
    private int length;

    public MyQueue() {
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

    public void clear() {
        MyNode element = last;
        for (int i = 0; i < length; i++) {
            MyNode prev = element.prev;
            element.next = null;
            element.prev = null;
            element.item = null;
            prev = element;
        }
        first = null;
        last = null;
        length = 0;
    }

    public int size() {
        return length;
    }

    public E peek() {
        return (E) first.item;
    }

    public E poll() {
        E result;
        MyNode element = first;
        result = (E) first.item;
        first = element.next;
        if(element.next == null) {
            clear();
        } else {
            element.next.prev = null;
            element = null;
            length--;
        }
        return result;
    }
}
