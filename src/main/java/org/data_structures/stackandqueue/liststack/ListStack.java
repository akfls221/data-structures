package org.data_structures.stackandqueue.liststack;

import java.util.EmptyStackException;

public class ListStack<E> {

    private Node<E> top; // 스택 top 항복을 가진 Node를 의미
    private int size;   // 스택의 항복수

    public ListStack() {
        this.top = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 스택 top 항목만을 반환
     *
     * @return E Item
     */
    public E peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        return this.top.getItem();
    }
}
