package org.data_structures.priorityqueue.binaryheap;

public class BHeap<Key extends Comparable<Key>, Value> {
    private Entry[] a;
    private int N;

    public BHeap(Entry[] a, int n) {
        this.a = a;
        N = n;
    }

    public int size() {
        return N;
    }

    /**
     * 두 키값중 더 큰 수를 비교
     *
     * @param i 비교 Entry 1
     * @param j 비교 Entry 2
     * @return
     */
    private boolean greater(int i, int j) {
        return a[i].getKey().compareTo(a[j].getKey()) > 0;
    }

    /**
     * i 와 j entry의 순서를 바꿈
     *
     * @param i 비교 Entry 1
     * @param j 비교 Entry 2
     */
    private void swap(int i, int j) {
        Entry temp = a[i];

        a[i] = a[j];
        a[j] = temp;
    }
}
