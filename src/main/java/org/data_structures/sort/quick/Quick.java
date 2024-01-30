package org.data_structures.sort.quick;

/**
 * 피벗 정렬
 *
 * 최선 : O(n logn)
 * 평균 : O(n logn)
 * 최악 : O(n²)
 */
public class Quick {


    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }

        int j = partition(a, low, high);
        sort(a, low, j - 1);    // 피벗보다 작은 부분을 순환 호출
        sort(a, j + 1, high);   // 피벗보다 큰 부분을 순환 호출
        
    }

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
