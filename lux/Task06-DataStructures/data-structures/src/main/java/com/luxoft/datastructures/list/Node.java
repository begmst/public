package com.luxoft.datastructures.list;

public class Node {
    Node next;
    Node prev;
    Object value;

    public Node(Object value) {
        this.value = value;
    }

    public Node(Object value, Node prev, Node next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

}