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

    /**
     * 새 항목을 push 하는 메소드
     * 
     * @param newItem   추가 하려는 항목
     */
    public void push(E newItem) {
        Node newNode = new Node(newItem, this.top); //리스트 앞부분에 삽입
        this.top = newNode; //top이 새로 추가돈 노드를 가리킴
        this.size++;    // 스택 항목 증가
    }

    /**
     * 현재 top을 제거하는 메소드
     * 
     * @return E topItem 삭제된 아이템
     */
    public E pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        E topItem = this.top.getItem(); // 현재 top 항목을 저장
        this.top = this.top.getNext();    //top이 바로 아래 항목을 가리킴.
        this.size--;    // 스택 항목수 감소

        return topItem;
    }
}
