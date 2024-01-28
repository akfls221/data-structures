package org.data_structures.priorityqueue.huffman;

public class Huffman {

    private Entry[] a; // a[0]은 미사용
    private int N;//힙의 크기

    public Huffman(Entry[] a, int initialSize) {
        this.a = a;
        N = initialSize;
    }

    private boolean greater(int i, int j) {
        return a[i].getKey() > a[j].getKey();
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

    public Entry createTree() {
        while (size() > 1) {
            Entry e1 = deleteMin();
            Entry e2 = deleteMin();
            Entry temp = new Entry(e1.getKey() + e2.getKey(),   //빈도수 합산
                    e1.getWord() + e2.getWord(),    // String 이어 붙이기
                    e1, e2, " ");   //e1, e2를 각각 왼쪽, 오른쪽 자식으로

            insert(temp);   //새 노드를 힙에 삽입
        }
        return deleteMin(); // 한개 남은 노드(허프만 계산 이후 즉 root 노드)제거 후 반환
    }

    /**
     * 새로운 키를 삽입
     */
    public void insert(Entry entry) {
        a[++N] = entry;  //새로운 키를 배열 마지막 항목 다음에 저장
        upheap(N);  //위로 올라가며 힙 속성 회복시키기 위해 재정렬
    }

    /**
     * 최솟값 삭제
     * @return
     */
    public Entry deleteMin() {
        Entry min = a[1]; // 삭제할 최소 Entry
        swap(1, N--);   // 힙의 마지막 항목과 교환하고 힙 크기 1감소
        a[N + 1] = null; // 마지막 항목은 Null 처리
        downheap(1);    // 힙속성 회복을 위한 downHeap
        return min;
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

    /**
     * 루트 방향으로 거슬러 올라가며 힙 속성이 어긋나는 경우 부모와 자식을 교환
     * @param j
     */
    private void upheap(int j) {    // j : 현재 노드의 인덱스
        while (j > 1 && greater(j / 2, j)) {    //현재 노드가 루트가 아니고 동시에 부모가 큰 경우
            swap(j / 2, j); //부모와 현재 노드 교환
            j = j / 2;  // 부모가 현재 노드가 되어 다시 반복하기 위함.
        }
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

    public int size() {
        return N;
    }
}
