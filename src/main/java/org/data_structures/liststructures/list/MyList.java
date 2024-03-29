package org.data_structures.liststructures.list;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyList<E> {

    private E array[]; //리스트의 항목을 저장할 배열

    private int size; //리스트의 항목 수

    public MyList() {
        this.array = (E[]) new Object[1];
        this.size = 0;
    }

    private MyList(E[] array, int size) {
        this.array = array;
        this.size = size;
    }

    static <E> MyList<E> testOf(E ...elements) {
        if (elements.length == 0) {
            return new MyList<>();
        }
        return new MyList<>(elements, elements.length);
    }

    public E get(int k) {
        if (size == 0 || k > size) {
            throw new NoSuchElementException();
        }
        return array[k];
    }

    public void add(E newElement) {
        if (size == array.length) {
            reSize(2*array.length);
        }
        array[size++] = newElement;
    }

    public void add(E newElement, int k) {
        if (size == array.length) {
            reSize(2*array.length);
        }
        for (int i = size -1; i >= k; i--) {
            array[i + 1] = array[i];
        }
        array[k] = newElement;
        size++;
    }

    public void delete(int k) {
        if (k > size || size == 0) {
            throw new NoSuchElementException();
        }

        for (int i = k; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;

        if (size > 0 && size == array.length / 4) {
            reSize(array.length / 2);
        }
    }

    private void reSize(int reSize) {
        Object[] t = new Object[reSize];
        for (int i = 0; i < this.size; i++) {
            t[i] = array[i];
        }
        array = (E[]) t;
    }


    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
