package org.data_structures.liststructures.doublelinkedlist;

/**
 * 이중 연결 리스트
 *
 * 단순연결 리스트는 역방향으로 리스트 탐색이 불가능 하다는 단점이 있음.
 * 이중 연결 리스트의 경우 이러한 단점을 보완하지만, 노드마다 추가로 1개의 레퍼런스를 저장해야 하는 단점을 가짐.
 */
public class DNode <E>{

    private E item;
    private DNode previous;
    private DNode next;

    public DNode(E item, DNode previous, DNode next) {
        this.item = item;
        this.previous = previous;
        this.next = next;
    }

    public E getItem() {
        return item;
    }

    public DNode getPrevious() {
        return previous;
    }

    public DNode getNext() {
        return next;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public void setPrevious(DNode previous) {
        this.previous = previous;
    }

    public void setNext(DNode next) {
        this.next = next;
    }
}
