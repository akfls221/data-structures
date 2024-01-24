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
}
