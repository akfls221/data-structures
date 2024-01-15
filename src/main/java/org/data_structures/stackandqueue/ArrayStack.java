package org.data_structures.stackandqueue;

import java.util.EmptyStackException;

public class ArrayStack<E> {
    private E s[];      //스택을 위한 배열
    private int top;    //스택의 top 항목의 배열 원소 인덱스

    public ArrayStack() {
        this.s = (E[]) new Object[1];   //초기에 크기가 1인 배열 생성
        this.top = -1;                  //top은 -1
    }
    
    public int size() {
        return top + 1;     //스택에 있는 항목의 수를 반환
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return this.s[this.top];    //배열의 가장 마지막(stack에선 가장위) 항목 반환
    }

    /**
     * 새 항복을 스택에 삽입한다.
     *
     * @param newItem   추가할 Item
     */
    public void push(E newItem) {
        //이미 배열이 꽉 찬 상태라면
        if (this.size() == this.s.length) {
            reSize(2*this.s.length);
        }

        this.s[this.top++] = newItem;
    }

    /**
     * 배열이 꽉찼을 경우 크기를 2배로 늘린다.
     * 
     * @param reSize    새롭게 늘릴 배열 크기
     */
    private void reSize(int reSize) {
        Object[] t = new Object[reSize];
        for (int i = 0; i < this.size(); i++) {
            t[i] = this.s[i];
        }
        this.s = (E[]) t;
    }
    
    
}
