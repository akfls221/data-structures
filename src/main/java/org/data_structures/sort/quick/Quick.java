package org.data_structures.sort.quick;

public class Quick {


    private static boolean isLess(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
