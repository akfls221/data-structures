package org.data_structures.sort.selectionsort;

public class Selection {

    /**
     * 원소 교환 메소드 최솟값을 a[i]와 바꾼다
     *
     * @param a     전체 배열
     * @param i     정렬된 배열 오른쪽 인덱스
     * @param j     정렬된 배열 오른쪽 기준 최솟값
     */
    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i]; //정렬된 배열의 바로 오른쪽 인덱스 값
        a[i] = a[j];    // 정렬된 배열 오른쪽 기준 최솟값으로 교체
        a[j] = temp;    // 해당 부분에 temp로 교체
    }
}
