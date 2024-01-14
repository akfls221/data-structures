package org.data_structures.circularlinkedlist;

import java.util.NoSuchElementException;

public class CList <E> {
    private Node last;
    private int size;

    public CList() {
        this.last = null;
        this.size = 0;
    }

    /**
     * 원형 연결 리스트 삽입
     *
     * @param newItem   추가하려는 Item
     */
    public void insert(E newItem) {
        //새로운 아이템에 대한 노드 생성
        Node newNode = new Node(newItem, null);

        if (last == null) {
            newNode.setNext(newNode);
            this.last = newNode;
            size++;
            return;
        }

        //newNode의 다음 노드가 last가 가리키는 노드의 다음 노드가 되도록(last, newNode ,어떤노드)
        newNode.setNext(this.last.getNext());
        this.last.setNext(newNode);
        size++;
    }

    /**
     * 리스트의 첫 노드를 삭제하는 메소드
     *
     * @return  삭제된 Node
     */
    public Node delete() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node x = this.last.getNext();
        if (x == this.last) {
            this.last = null;
            this.size--;
            return x;
        }

        this.last.setNext(x.getNext());
        x.setNext(null);
        this.size--;
        return x;
    }

    private boolean isEmpty() {
        return this.size == 0 || this.last == null;
    }
}
