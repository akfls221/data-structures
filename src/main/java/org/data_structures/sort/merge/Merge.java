package org.data_structures.sort.merge;

public class Merge {

    public static void sort(Comparable[] a) {
        Comparable[] b = new Comparable[a.length];
        sort(a, b, 0, a.length -1);
    }

    private static void sort(Comparable[] a, Comparable[] b, int low, int high) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;   //중간 index
        sort(a, b, low, mid);   //앞부분 순환 호출
        sort(a, b, mid + 1, high);  //뒷부분 순환 호출
        merge(a, b, 0, a.length - 1);
    }

    private static boolean isLess(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
}
