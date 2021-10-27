package com.luxoft.datastructures.queue;

import java.util.Arrays;

public class ArrayQueue implements Queue {

    private int size = 0;
    private Object[] array;
    private int addedCount = 0;
    private int removedCount = 0;

    public ArrayQueue(int size) {
        this.array = new Object[size];
    }
    public ArrayQueue() {
        this(10);
    }

    private void ensureCapacity() {
        if (this.array.length == this.size) {
            Object[] newList = new Object[this.array.length * 2];
            for (int i = 0; i < this.array.length; i++) {
                newList[i] = this.array[i];
            }
            this.array = newList;
        }
    }

    private void optimize() {
        if (this.array.length > 1) {
            Object[] newList = new Object[this.array.length / 2];
            for (int i = 0; i < this.size; i++) {
                newList[i] = this.array[this.removedCount + i];
            }
            for (int i = 0; i < this.removedCount; i++) {
                this.array[i] = null;
            }
            this.array = newList;
            this.addedCount = this.size;
            this.removedCount = 0;
        }
    }

    @Override
    public void enqueue(Object value) {
        this.ensureCapacity();
        this.array[this.size] = value;
        this.size++;
        this.addedCount++;
    }

    @Override
    public Object dequeue() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        Object result = this.array[this.removedCount];
        this.size--;
        this.removedCount++;
        if (this.size == 1) {
            this.optimize();
        }
        return result;
    }

    @Override
    public Object peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        return this.array[this.removedCount];
    }

    public String toString() {
        Object[] newList = new Object[this.size];
        for (int i = this.removedCount; i < this.removedCount + this.size; i++) {
            newList[i] = this.array[i];
        }
        String result = String.format("[%s]", String.join(", ", Arrays.stream(newList).toArray(String[]::new)));
        return result;
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object value) {
        for (int i = this.removedCount; i < this.removedCount + this.size; i++) {
            Object valueInStack = array[i];
            if (value.equals(valueInStack)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = this.removedCount; i < this.removedCount + this.size; i++) {
            this.array[i] = null;
        }
        this.size = 0;
        this.addedCount = 0;
        this.removedCount = 0;
    }
}
