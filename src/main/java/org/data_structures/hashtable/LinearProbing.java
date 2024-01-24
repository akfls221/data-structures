package org.data_structures.hashtable;

/**
 *  해시테이블 개방 주소 방식의 선형 조사
 *  해시 충돌시 개방주소 방식 중 선형 조사에 관련되 클래스다.
 *
 * @param <K>   키
 * @param <V>   값
 */
public class LinearProbing<K, V> {
    private int M = 13; //테이블 크기
    private K[] a = (K[]) new Object[M]; // 해시 테이블
    private V[] d = (V[]) new Object[M]; // key 관련 데이터 저장

    private int hash(K key) { //해시 함수
        return (key.hashCode() & 0x7fffffff) % M; //나눗셉 함수
    }

    /**
     * key 와 value 저장
     * 
     * @param key   삽입 하려는 key
     * @param value 삽입 하려는 value
     */
    private void put(K key, V value) { //삽입 연산
        int initialpos = hash(key); // 초기 시작위치
        int i = initialpos;
        int j = 1;

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

            i = (initialpos + j++) % M; // i = 다음 위치
        } while (i != initialpos);
        System.out.println("저장 실패");
    }

    /**
     * 특정 key로 탐색하는 get 메서드
     * 
     * @param key 탐색하려는 key 값
     * @return V 값
     */
    public V get(K key) {
        int initialpos = hash(key); //초기 위치
        int i = initialpos;
        int j = 1;

        while (a[i] != null) { //a[i]가 null이 아니면
            if (a[i].equals(key)) {
                return d[i];
            }

            i = (initialpos + j++) % M; // i = 다음위치
        }
        return null; // 탐색 실패
    }
}
