package org.data_structures.priorityqueue.binaryheap;

public class BHeap<Key extends Comparable<Key>, Value> {
    private Entry[] a;
    private int N;

    public BHeap(Entry[] a, int n) {
        this.a = a;
        N = n;
    }

    /**
     * 새로운 키를 삽입
     * @param newKey    새로운 키
     * @param newValue  새로운 값
     */
    public void insert(Key newKey, Value newValue) {
        Entry temp = new Entry(newKey, newValue);   //entry 새성
        a[++N] = temp;  //새로운 키를 배열 마지막 항목 다음에 저장
        upheap(N);  //위로 올라가며 힙 속성 회복시키기 위해 재정렬
    }

    /**
     * 상향식 힙 만들기
     *
     * 2/N을 하는 이유는 가장 마지막 이파리 노드의 부모에서 부터힙 연산을 수행하기 위함이다.
     */
    public void createHeap() {
        for (int i = 2 / N; i > 0; i--) {
            downheap(i);
        }
    }

    /**
     * 자식 노드와 비교하는 downHeap 메소드
     * @param i
     */
    private void downheap(int i) {
        while (2 * i <= N) {    // 왼쪽 자식이 힙에 있으면
            int k = 2 * i;      // k = 왼쪽 자식의 인덱스
            if (k < N && greater(k, k + 1)) {   //k 가 승자
                k++;    //의미 없는 코드인듯 후위연산자를 사용하는 의미없는 코드
            }

            if (!greater(i, k)) {   //현재 노드가 자식의 승자와 같거나 작으면 루프 중단
                break;
            }
            swap(i, k);
            i = k;
        }
    }

    public int size() {
        return N;
    }

    /**
     * 두 키값중 더 큰 수를 비교
     *
     * @param i 비교 Entry 1
     * @param j 비교 Entry 2
     * @return
     */
    private boolean greater(int i, int j) {
        return a[i].getKey().compareTo(a[j].getKey()) > 0;
    }

    /**
     * i 와 j entry의 순서를 바꿈
     *
     * @param i 비교 Entry 1
     * @param j 비교 Entry 2
     */
    private void swap(int i, int j) {
        Entry temp = a[i];

        a[i] = a[j];
        a[j] = temp;
    }
}
