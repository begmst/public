package com.luxoft.datastructures.list;

import java.util.Iterator;
import java.util.StringJoiner;

public class LinkedList implements List, Iterable {

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(Object value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(Object value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(Object value) {
        addLast(value);
    }

    public void add(Object ...value) {
        for (Object v : value) {
            add(v);
        }
    }

    @Override
    public void add(Object value, int index) {
        ensureIndex(index, false);
        if (isEmpty()) {
            addFirst(value);
        } else if (index == (size - 1)) {
            addLast(value);
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Node newNode = new Node(value, current.prev, current);
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        ensureIndex(index);
        if (!isEmpty()) {
            Node current = head;
            if (size == 1) {
                head = tail = null;
            } else if (index == 0) {
                head = current.next;
                head.prev = null;
            } else if (index == (size - 1)) {
                current = tail;
                tail = current.prev;
                tail.next = null;
            } else {
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
            return current.value;
        }
        return null;
    }

    @Override
    public Object get(int index) {
        ensureIndex(index);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public Object set(Object value, int index) {
        ensureIndex(index);
        if (!isEmpty()) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Node newNode = new Node(value, current.prev, current.next);
            current.prev.next = current.next.prev = newNode;
            return current.value;
        }
        return null;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object value) {
        Node current = head;
        do {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        } while (current != null);
        return false;
    }

    @Override
    public int indexOf(Object value) {
        if (!isEmpty()) {
            Node current = head;
            for (int i = 0; i < size; i++) {
                if (current.value.equals(value)) {
                    return i;
                }
                current = current.next;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        if (!isEmpty()) {
            Node current = tail;
            for (int i = size - 1; i >= 0; i--) {
                if (current.value.equals(value)) {
                    return i;
                }
                current = current.prev;
            }
        }
        return -1;
    }

    public String toString() {
        StringJoiner line = new StringJoiner(", ", "[", "]");
        for (Object value : this) {
            line.add(value.toString());
        }
        return line.toString();
    }


    private void ensureIndex(int index, boolean strict) {
        boolean cond;
        if (strict) {
            cond = index < size;
        } else {
            cond = index <= size;
        }
        if (!cond) {
            throw new IndexOutOfBoundsException(String.format("Invalid index, it shouldn't be greater than %d.", size));
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("Invalid index, it cannot be a negative value.");
        }
    }

    private void ensureIndex(int index) {
        ensureIndex(index, true);
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node current = new Node(null, null, head);
            @Override
            public boolean hasNext() {
                if (isEmpty()) {
                    return false;
                }
                return current.next != null;
            }

            @Override
            public Object next() {
                current = current.next;
                return current.value;
            }
        };
    }
}