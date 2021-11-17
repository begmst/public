package com.luxoft.datastructures.list;

import java.util.Arrays;

public class TArrayList<T> implements TList<T> {

    private int size = 0;
    private T[] array;

    public TArrayList(int size) {
        this.array = (T[])new Object[size];
    }
    public TArrayList() {
        this(10);
    }

    private void ensureCapacity() {
        if (this.array.length == this.size) {
            T[] newList = (T[])new Object[this.array.length * 2];
            for (int i = 0; i < this.array.length; i++) {
                newList[i] = this.array[i];
            }
            this.array = newList;
        }
    }

    private void ensureIndex(int index, boolean strict) {
        boolean cond;
        if (strict) {
            cond = index > this.size;
        } else {
            cond = index >= this.size;
        }
        if (cond) {
            throw new IndexOutOfBoundsException(String.format("Invalid index, it shouldn't be greater than %d.", this.size));
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("Invalid index, it cannot be a negative value.");
        }
    }

    private void ensureIndex(int index) {
        this.ensureIndex(index, true);
    }

    @Override
    public void add(T value) {
        this.ensureCapacity();
        this.array[this.size] = value;
        this.size++;
    }

    @Override
    public void add(T value, int index) {
        this.ensureIndex(index, false);
        this.ensureCapacity();
        for (int i = this.size; i > index; i--) {
            this.array[i] = this.array[i - 1];
        }
        this.array[index] = value;
        this.size++;
    }

    @Override
    public T remove(int index) {
        this.ensureIndex(index);
        T result = this.get(index);
        for (int i = index; i < size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.array[size - 1] = null;
        this.size--;
        return result;
    }

    @Override
    public T get(int index) {
        this.ensureIndex(index);
        return this.array[index];
    }

    @Override
    public T set(T value, int index) {
        this.ensureIndex(index);
        T result = this.array[index];
        this.array[index] = value;
        return result;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.array[i] = null;
        }
        this.size = 0;
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
    public boolean contains(T value) {
        return this.indexOf(value) != -1;
    }

    @Override
    public int indexOf(T value) {
        for (int i = 0; i < this.size; i++) {
            if (value.equals(this.array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        for (int i = this.size - 1; i >= 0; i--) {
            if (value.equals(this.array[i])) {
                return i;
            }
        }
        return 1;
    }

    public String toString() {
        String result = String.format("[%s]", String.join(", ", Arrays
            .stream(this.array)
            .filter(value -> value != null)
            .toArray(String[]::new)
        ));
        return result;
    }
}
