package org.data_structures.sort.shell;

public class Shell {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 4; // 3X + 1간격 : 1, 4, 13, 40....중에서 4와 1만을 사용
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && isless(a[j], a[j-h]); j -= h) {
                    swap(a, j, j-h);
                }
            }
            h /= 3;
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
