package org.data_structures.stackandqueue.queue.list;

import java.util.NoSuchElementException;

public class ListQueue <E> {

    private Node<E> front;

    private Node<E> rear;

    private int size;

    public ListQueue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    /**
     * 단순 연결 리스트 Queue 삽입
     * 
     * @param newItem 큐에 삽입할 아이템
     */
    public void add(E newItem) {
        Node<E> addItem = new Node<>(newItem, null);
        if (isEmpty()) {
            this.front = addItem;
        } else {
            this.rear.setNext(addItem);
        }

        this.rear = addItem;
        this.size++;
    }

    /**
     * 단순 연결 리스트 Queue 삭제
     * 
     * @return E 삭제한 아이템
     */
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        E frontItem = this.front.getItem();
        this.front = this.front.getNext();

        if (isEmpty()) {
            this.rear = null;
        }
        this.size--;

        return frontItem;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
