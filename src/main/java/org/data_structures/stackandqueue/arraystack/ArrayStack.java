package org.data_structures.stackandqueue.arraystack;

import java.util.Arrays;
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

        //추가하기전에 this.top을 1증가 시킨다
        this.s[++this.top] = newItem;
    }

    /**
     * 스택의 가장 위의 항목을 삭제한다.
     *
     * @return E 삭제된 아이템 반환
     */
    public E pop() {
        //배열이 비어있다면 Exception
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        E popItem = s[this.top];
        //현재 top을 null로 초기화 하고, top을 -1 한다.
        this.s[this.top--] = null;

        if (this.size() > 0 && this.size() == this.s.length / 4) {
            reSize(this.s.length/2);
        }

        return popItem;
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

    @Override
    public String toString() {
        return "ArrayStack{" +
                "s=" + Arrays.toString(s) +
                ", top=" + top +
                '}';
    }
}
