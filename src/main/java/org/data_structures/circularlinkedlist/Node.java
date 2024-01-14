package org.data_structures.circularlinkedlist;

public class Node<E> implements Comparable{

    private E item;

    private Node<E> next;

    public Node(E item, Node<E> next) {
        this.item = item;
        this.next = next;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                ", next=" + next +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (this.item.equals(o)) {
            return 0;
        }
        return 1;
    }
}
