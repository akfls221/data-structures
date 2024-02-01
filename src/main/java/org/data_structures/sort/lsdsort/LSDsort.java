package org.data_structures.sort.lsdsort;

public class LSDsort {

    public static void sort(int[] a) {
        int R = 10; //1의자리 100 : 10의 자리 1000 : 100의 자리
        int N = a.length;
        int[] t = new int[N];

        for (int k = 10; k <= 1000; k *= 10) {
            int[] startIndex = new int[R + 1];
            for (int i = 0; i < N; i++) {
                startIndex[(a[i] % k) / (k / 10) + 1]++; //a[i]의 각 자릿수 추출
            }

            for (int r = 0; r < R; r++) {
                startIndex[r + 1] += startIndex[r];
            }

            for (int i = 0; i < N; i++) {
                t[startIndex[(a[i] % k) / (k / 10)]++] = a[i];
            }

            for (int i = 0; i < N; i++) {
                a[i] = t[i];
            }

            System.out.println(k/10 + "의 자리 정렬 결과 : ");

            for (int i = 0; i < N; i++) {
                System.out.println(String.format("%03d", a[i]) + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] a = {251, 430, 301, 540, 551, 401, 2, 10, 124, 22, 204, 115};
        sort(a);
    }
}
