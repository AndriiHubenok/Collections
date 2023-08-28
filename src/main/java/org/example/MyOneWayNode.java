package org.example;

public class MyOneWayNode<K, V> {
    K key;
    V value;
    MyOneWayNode next;

    public MyOneWayNode(K key , V value, MyOneWayNode next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
