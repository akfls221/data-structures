package org.data_structures.priorityqueue.huffman;

public class Huffman {

    private Entry[] a; // a[0]은 미사용
    private int N;//힙의 크기

    public Huffman(Entry[] a, int initialSize) {
        this.a = a;
        N = initialSize;
    }

    private boolean greater(int i, int j) {
        return a[i].getKey() > a[j].getKey();
    }
}
