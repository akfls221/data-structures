package org.data_structures.sort.quick;

public class Quick {

    private static int partition(Comparable[] a, int pivot, int high) {
        int i = pivot;
        int j = high + 1;
        Comparable p = a[pivot];

        while (true) {
            while (isLess(a[++i], p)) { //피벗 보다 작으면
                if (i == high) {
                    break;
                }
                while (isLess(p, a[--j])) { // 피벗보다 크면
                    if (j == pivot) {
                        break;
                    }
                }

                if (i >= j) {
                    break;
                }
                swap(a, i, j);
                return j;
            }
        }
    }


    private static boolean isLess(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
