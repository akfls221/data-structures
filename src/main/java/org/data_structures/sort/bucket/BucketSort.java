package org.data_structures.sort.bucket;

public class BucketSort {

    public static void sort(int[] a, int R) {
        int[] bucket = new int[R];
        for (int i = 0; i < R; i++) {   //초기화
            bucket[i] = 0;
        }

        for (int i = 0; i < a.length; i++) {    //1단계 : 빈도수 계산
            bucket[a[i]]++;
        }
        int j = 0; // j는 다음 저장될 배열 a 원소의 인덱스
        for (int i = 0; i < R; i++) {
            while ((bucket[i]--) != 0) { // 버킷 i에 저장된 빈도수가 0이 될 때까지
                a[j++] = i;
            }
        }
    }
}
