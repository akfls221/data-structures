package org.data_structures.list;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyList<E> {

    private E array[]; //리스트의 항목을 저장할 배열

    private int size; //리스트의 항목 수

    private MyList() {
        array = (E[]) new Object[0];
        size = 0;
    }

    private MyList(E[] array, int size) {
        this.array = array;
        this.size = size;
    }

    static <E> MyList<E> of(E ...elements) {
        if (elements.length == 0) {
            return new MyList<>();
        }
        return new MyList<>(elements, elements.length);
    }


    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
