package org.data_structures.linkedlist;

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
}
