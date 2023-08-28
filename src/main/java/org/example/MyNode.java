package org.example;

public class MyNode<E> {
    E item;
    MyNode next;
    MyNode prev;

    public MyNode(MyNode prev, E element, MyNode next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}
