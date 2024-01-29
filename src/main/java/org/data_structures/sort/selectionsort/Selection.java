package org.data_structures.sort.selectionsort;

public class Selection {

    /**
     * 선택 정렬
     * 
     * @param a 정렬하려는 메소드
     */
    public static void sort(Comparable[] a) {
        int N  = a.length;
        for (int i = 0; i < N; i++) { // 전체 배열을 루프 돌면서
            int min = i;

            for (int j = i+1; j < N; j++) { // min 탐색
                if (isless(a[j], a[min])) {
                    min = j;
                }
            }
            swap(a, i, min);    //swap
        }
    }

    /**
     *  키 비교 메소드
     *
     * @param i
     * @param j
     * @return
     */
    private static boolean isless(Comparable i, Comparable j) {
        return (i.compareTo(j) < 0);
    }

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
