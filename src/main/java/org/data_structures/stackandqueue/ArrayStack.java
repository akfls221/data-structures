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
    
    
}
