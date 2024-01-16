package org.data_structures.stackandqueue.queue;

public class ArrayQueue <E> {

    private E[] queue; // 큐를 위한 배열
    private int front;
    private int rear;
    private int size;

    public ArrayQueue() {
        this.queue = (E[]) new Object[2]; //초기에 크기가 2인 배열 생성(front, rear)
        this.front = this.rear = this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
