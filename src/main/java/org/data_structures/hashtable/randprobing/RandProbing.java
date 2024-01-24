package org.data_structures.hashtable.randprobing;

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
}
