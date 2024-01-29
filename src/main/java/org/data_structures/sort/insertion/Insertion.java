package org.data_structures.sort.insertion;

/**
 * 삽입 정렬
 *
 * O(n²) 수행시간이 소요
 * 이미 정렬된 파일의 뒷부분에 소량의 신규 데이터를 추가하여 정렬하는 경우 우수한 성능을 보인다.
 */
public class Insertion {

    public static void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (isless(a[j], a[j - 1])) {
                    swap(a, j, j - 1);
                } else {
                    break;
                }
            }
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
