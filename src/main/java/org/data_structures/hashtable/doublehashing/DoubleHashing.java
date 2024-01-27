package org.data_structures.hashtable.doublehashing;

public class DoubleHashing<K, V> {
    private int N = 0;
    private int M = 13; //테이블 크기
    private K[] a = (K[]) new Object[M]; // 해시 테이블
    private V[] dt = (V[]) new Object[M]; // key 관련 데이터 저장

    private int hash(K key) { //해시 함수
        return (key.hashCode() & 0x7fffffff) % M; //나눗셉 함수
    }

    /**
     * 이중해시 삽입 메소드
     * 
     * @param key   삽입하려는 키
     * @param value 삽입하려는 값
     */
    public void put(K key, V value) {
        int initialpos = hash(key);
        int i = initialpos;
        int j = 1;
        int loopLimit = 20;
        int d = (7 - (int) key % 7); // 두 번째 해시 함수, d(key) = 7-key%7

        do {
            if (a[i] == null) {
                a[i] = key;     // key를 해시테이블에 저장
                dt[i] = value;  // 데이터 저장
                N++;
                return;
            }
            if (a[i].equals(key)) {
                dt[i] = value;
                return;
            }
            i = (initialpos + j * d) % M;   //i의 다음 위치
            loopLimit -= 1;
            j++;
        } while (loopLimit > 0);
        System.out.println("저장 실패");
    }
}
