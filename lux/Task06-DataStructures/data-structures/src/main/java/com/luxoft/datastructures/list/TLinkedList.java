package com.luxoft.datastructures.list;

import java.util.Iterator;
import java.util.StringJoiner;

public class TLinkedList<T> implements TList<T>, Iterable<T> {

    private TNode<T> head;
    private TNode<T> tail;
    private int size;

    public void addFirst(T value) {
        TNode<T> newNode = new TNode<T>(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(T value) {
        TNode<T> newNode = new TNode<T>(value);
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
    public void add(T value) {
        addLast(value);
    }

    public void add(T ...value) {
        for (T v : value) {
            add(v);
        }
    }

    @Override
    public void add(T value, int index) {
        ensureIndex(index, false);
        if (isEmpty()) {
            addFirst(value);
        } else if (index == (size - 1)) {
            addLast(value);
        } else {
            TNode<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            TNode<T> newNode = new TNode<T>(value, current.prev, current);
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        ensureIndex(index);
        if (!isEmpty()) {
            TNode<T> current = head;
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
    public T get(int index) {
        ensureIndex(index);
        TNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public T set(T value, int index) {
        ensureIndex(index);
        if (!isEmpty()) {
            TNode<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            TNode<T> newNode = new TNode<T>(value, current.prev, current.next);
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
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(T value) {
        if (!isEmpty()) {
            TNode<T> current = head;
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
            TNode<T> current = tail;
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
        for (T value : this) {
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
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            TNode<T> current = new TNode<T>(null, null, head);
            @Override
            public boolean hasNext() {
                if (isEmpty()) {
                    return false;
                }
                return current.next != null;
            }

            @Override
            public T next() {
                current = current.next;
                return current.value;
            }
        };
    }
}

class TNode<T> {
    TNode<T> next;
    TNode<T> prev;
    T value;

    public TNode(T value) {
        this.value = value;
    }

    public TNode(T value, TNode<T> prev, TNode<T> next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}
