package org.data_structures.list;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyList<E> {

    private E array[]; //리스트의 항목을 저장할 배열

    private int size; //리스트의 항목 수

    public MyList() {
        array = (E[]) new Object[1];
        size = 0;
    }

    public MyList(E[] array, int size) {
        this.array = array;
        this.size = size;
    }

    static <E> MyList<E> of(E ...elements) {
        return new MyList<>(elements, elements.length);
    }


    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }
}
