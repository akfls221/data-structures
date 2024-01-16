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

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void resize(int resize) {
        Object[] resizeQueue = new Object[resize];

        for (int i = 0; i < this.queue.length; i++) {
            resizeQueue[i] = this.queue[i];
        }

        this.queue = (E[]) resizeQueue;
    }
}
