package org.data_structures.stackandqueue.queue.list;

public class ListQueue <E> {

    private Node<E> front;

    private Node<E> rear;

    private int size;

    public ListQueue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
