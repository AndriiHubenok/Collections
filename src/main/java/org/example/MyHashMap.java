package org.example;

public class MyHashMap<K, V> {
    private MyOneWayNode first;
    private int length;

    public MyHashMap() {
        this.first = null;
    }

    public void put(K key, V value) {
        if(findElement(key) == null) {
            MyOneWayNode next = first;
            MyOneWayNode node = new MyOneWayNode<>(key, value, next);
            first = node;
            length++;
        }
    }

    public void remove(K key) {
        MyOneWayNode element = first;
        int indexOfElement = 0;
        MyOneWayNode next = null;
        for(int i = 0; i < length; i++) {
            if(element.key == key) {
                if(element == first) {
                    first = element.next;
                    element = null;
                    length--;
                    break;
                }
                next = element.next;
                element = null;
                indexOfElement = i;
                element = first;
                i = 0;
                continue;
            }
            if(i == indexOfElement - 1) {
                element.next = next;
                length--;
                break;
            }
            element = element.next;
        }
    }

    public void clear() {
        MyOneWayNode element = first;
        MyOneWayNode next = null;
        for(int i = 0; i < length; i++) {
            if(i == length - 1) {
                element = null;
                break;
            }
            next = element.next;
            element = null;
            element = next;
        }
        length = 0;
    }

    public int size() {
        return length;
    }

    public V get(K key) {
        return (V) findElement(key).value;
    }

    private MyOneWayNode findElement(K key) {
        MyOneWayNode element = first;
        for(int i = 0; i < length; i++) {
            if(element.key == key) {
                return element;
            }
            element = element.next;
        }
        return null;
    }
}
