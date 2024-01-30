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
        merge(a, b, low, mid, high);
    }

    private static void merge(Comparable[] a, Comparable[] b, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        for (int k = low; k < high; k++) {
            if (i > mid) {  // 앞부분이 먼저 소진된 경우
                b[k] = a[j++];
            } else if (j < high) {  // 뒷부분이 먼저 소진된 경우
                b[k] = a[i++];
            } else if (isLess(a[i], a[j])) {    // a[j]가 승자
                b[k] = a[j++];
            } else {    //a[i]가 승자
                b[k] = a[i++];
            }
        }
        for (int k = low; k <= high; k++) {
            a[k] = b[k];
        }
    }


    private static boolean isLess(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
}
