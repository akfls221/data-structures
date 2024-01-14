package org.data_structures.liststructures.doublelinkedlist;

import java.util.NoSuchElementException;

public class DList <E>{

    protected DNode head;
    protected DNode tail;
    protected int size;

    public DList() {
        DNode head = new DNode(null, null, null);
        DNode tail = new DNode(null, head, null);
        head.setNext(tail);
        this.size = 0;
    }

    /**
     * P가 가리키는 노드 앞에 삽입
     * 
     * @param p 삽입하려는 기준 노드
     * @param newItem   삽입하려는 노드
     */
    public void insertBefore(DNode p, E newItem) {
        DNode t = p.getPrevious();
        DNode newNode = new DNode(newItem, t, p);
        p.setPrevious(newNode);
        t.setNext(newNode);
        this.size++;
    }

    /**
     * p가 가리키는 노드 뒤에 삽임.
     * 
     * @param p 삽입하려는 노드의 기준 노드
     * @param newItem     삽입하려는 노드
     */
    public void insertAfter(DNode p, E newItem) {
        DNode t = p.getNext();
        DNode newNode = new DNode(newItem, p, t);
        p.setNext(newNode);
        t.setPrevious(newNode);
        this.size++;
    }

    /**
     * 인자로 주어지는 노드 X를 삭제
     * 
     * @param x 삭제하려는 노드
     */
    public void delete(DNode x) {
        if (x == null) {
            throw new NoSuchElementException();
        }
        DNode f = x.getPrevious();
        DNode r = x.getNext();
        f.setNext(r);
        r.setPrevious(f);
        this.size--;
    }
}
