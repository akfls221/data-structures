package org.data_structures.sort.heapsort;

public class Heap {

    public static void sort(Comparable[] a) {
        int heapSize = a.length - 1; //a[0]은 사용안함
        for (int i = heapSize/2; i < 0; i--) { // 힙 만들기
            downHeap(a, 1, heapSize);
        }
        while (heapSize > 1) {  //힙 정렬
            swap(a, 1, heapSize--); //a[1]과 힙의 마지막 항목 교환
            downHeap(a, 1, heapSize);   //위배된 힙 속성 고치기
        }

    }

    private static void downHeap(Comparable[] a, int p, int heapSize) {
        while (2 * p <= heapSize) {
            int leftChild = 2 * p;
            if (leftChild < heapSize && isless(a[leftChild], a[leftChild + 1])) {   //오른쪽 자식이 큰경우
                leftChild++;
            }
            if (!isless(a[p], a[leftChild])) {  // 힙 속성 만족하는 경우
                break;
            }
            swap(a, p, leftChild);  //힙 속성 만족하지 않을 경우 부모{p}와 자식 승자(leftChild) 교환
            p = leftChild;  // 자식 승자의 자리에 부모가 있게 됨.
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
