package com.codegym.list;

import java.util.ArrayList;
import java.util.Iterator;

import org.hamcrest.internal.ArrayIterator;

public class MyArrayList<E> extends MyAbstractList<E> {
    public static final int INTIAL_CAPACITY = 16;
    private E[] data = (E[]) new Object[INTIAL_CAPACITY];

    public MyArrayList() {
    }

    public MyArrayList(E[] object) {
        for (int i = 0; i < object.length; i++) {
            add(object[i]);
        }
    }

    public void trimToSize() {
        if (size != data.length) {
            E[] newData = (E[]) new Object[size];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    private void ensureCapacity() {
        if (size >= data.length) {
            E[] newData = (E[]) new Object[size * 2 + 1];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index " + index + " out of bounds");
        }
    }

    @Override
    public void add(int index, E e) {
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    @Override
    public void clear() {
        data = (E[]) new Object[INTIAL_CAPACITY];
        size = 0;

    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;

    }

    @Override
    public int lastIndexOf(E e) {
        for (int i = size - 1; i >= 0; i--) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        E e = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return e;

    }

    @Override
    public E set(int index, E e) {
        checkIndex(index);
        E old = data[index];
        data[index] = e;
        return old;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }

        return "[" + result.toString() + "]";
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements java.util.Iterator<E> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public E next() {
            return data[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(current);
        }
    }

    public static void main(String[] args) {
        MyList<String> list = new MyArrayList<>();

        list.add("America");
        System.out.println("(1) " + list);

        list.add(0, "Canada");
        System.out.println("(2) " + list);

        list.add("Russia");
        System.out.println("(3) " + list);

        list.add("France");
        System.out.println("(4) " + list);

        list.add(2, "Germany");
        System.out.println("(5) " + list);

        list.add(5, "Norway");
        System.out.println("(6) " + list);

        list.remove("Canada");
        System.out.println("(7) " + list);

        list.remove(2);
        System.out.println("(8) " + list);

        list.remove(list.size() - 1);
        System.out.println("(9) " + list);

        for (String string : list) {
            System.out.print("(10) " + string.toUpperCase() + " ");
        }
    }
}
