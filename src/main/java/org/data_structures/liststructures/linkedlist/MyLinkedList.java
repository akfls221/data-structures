package org.data_structures.liststructures.linkedlist;

import java.util.NoSuchElementException;

/**
 * 단순 연결 리스트
 * @param <E>
 */
public class MyLinkedList<E> {

    private Node<E> head;

    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void insertFront(E newItem) {
        this.head = new Node<>(newItem, this.head);
        size++;
    }

    public void insertAfter(E newItem, Node<E> p) {
        p.setNext(new Node<>(newItem, p.getNext()));
        size++;
    }

    public void deleteFront() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        head = head.getNext();
        size--;
    }

    public void deleteAfter(Node p) {
        if (p == null) {
            throw new NoSuchElementException();
        }
        Node t = p.getNext();
        p.setNext(t.getNext());
        t.setNext(null);
        size --;
    }

    public int search(E target) {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        Node p = head;
        for (int i = 0; i < size; i++) {
            if (p.compareTo(target) == 0) {
                return i;
            }
            p = p.getNext();
        }
        return -1;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }
}
