package org.data_structures.hashtable.randprobing;

import java.util.Random;

/**
 * 랜덤 조사
 * 점프 시퀀스를 무작위화하여 empty원소를 찾는 충돌 해결 방법(3차 군집화가 발생한다.)
 * 
 * @param <K> 키
 * @param <V> 값
 */
public class RandProbing<K, V> {
    private int N = 0;
    private int M = 13; //테이블 크기
    private K[] a = (K[]) new Object[M]; // 해시 테이블
    private V[] d = (V[]) new Object[M]; // key 관련 데이터 저장

    private int hash(K key) { //해시 함수
        return (key.hashCode() & 0x7fffffff) % M; //나눗셉 함수
    }

    /**
     * 삽입 메소드
     *
     * @param key   키
     * @param value 값
     */
    public void put(K key, V value) {
        int initialpos = hash(key);
        int i = initialpos;
        int loopLimit = 20;
        Random random = new Random();
        random.setSeed(10);

        do {
            if (a[i] == null) { // 삽입 위치 발견
                a[i] = key; // key를 해시 테이블에 저장
                d[i] = value; // value를 동일한 인덱스 하에 저장
                return;
            }

            if (a[i].equals(key)) { //이미 존재하는 key
                d[i] = value;       // value만 갱신
                return;
            }
            i = (initialpos + random.nextInt(1000)) % M;
            loopLimit -= 1;

        } while (loopLimit > 0);
        System.out.println("저장 실패");
    }

    /**
     * 특정 key로 탐색하는 get 메서드
     *
     * @param key 탐색하려는 key 값
     * @return V 값
     */
    public V get(K key) {
        Random random = new Random();
        random.setSeed(10);
        int initialpos = hash(key);
        int i = initialpos;
        int limitLoop = 20;

        while (a[i] != null && limitLoop > 0) {
            if (a[i].equals(key)) {
                return d[i];
            }
            i = (initialpos + random.nextInt(1000)) % M;
            limitLoop -= 1;
        }
        return null;
    }
}
