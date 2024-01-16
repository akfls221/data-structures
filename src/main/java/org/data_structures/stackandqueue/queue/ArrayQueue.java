package org.data_structures.stackandqueue.queue;

import java.util.NoSuchElementException;

/**
 * Front는 빈공란으로 둔다 즉 배역의 1개 원소는 사용하지 않는다.
 *
 * @param <E>
 */
public class ArrayQueue <E> {

    private E[] queue; // 큐를 위한 배열
    private int front;
    private int rear;
    private int size;

    public ArrayQueue() {
        this.queue = (E[]) new Object[2]; //초기에 크기가 2인 배열 생성(front, rear)
        this.front = this.rear = this.size = 0;
    }

    /**
     * Queue 삽입 연산
     * 
     * @param newItem   큐에 추가할 새로운 아이템
     */
    public void add(E newItem) {
        if ((this.rear + 1) % this.queue.length == this.front) { //빈 원소가 1개뿐인 경우 resize(큐가 full인 경우)
            resize(2 * this.queue.length);
        }

        this.rear = (this.rear + 1) % this.queue.length;
        this.queue[this.rear] = newItem;
        this.size++;
    }

    /**
     * Queue 삭제 연산
     * 
     * @return  E 삭제된 아이템
     */
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        this.front = (this.front + 1) % this.queue.length;
        E removeItem = this.queue[this.front];
        this.queue[this.front] = null;

        this.size--;

        if (this.size > 0 && this.size == this.queue.length/4) {
            resize(this.queue.length/2);
        }

        return removeItem;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void resize(int resize) {
        Object[] resizeQueue = new Object[resize];

        for (int i = 1, j = this.front + 1; i < this.size; i++, j++) {
            resizeQueue[i] = this.queue[j % this.queue.length];
        }

        this.front = 0;
        this.rear = this.size;
        this.queue = (E[]) resizeQueue;
    }
}
