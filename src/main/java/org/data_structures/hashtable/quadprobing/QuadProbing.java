package org.data_structures.hashtable.quadprobing;

/**
 * 이차조사
 * 선형 조사와 근본적으로 동일한 충돌 해결 방법 다만 충돌시 다음 키를(hash(key) * j²) 에 넣는다.
 *
 * 1차 군집을 해결할 수 있지만 2차군집이 초래되며, 제곱반큼씩 커지므로 배열에 empty 원소가 있는데도 empty원소를 건너뛰어
 * 탐색에 실패하는 경우도 피할 수 없다.
 *
 * @param <K>   키
 * @param <V>   값
 */
public class QuadProbing<K, V> {
    private int M = 13; //테이블 크기
    private K[] a = (K[]) new Object[M]; // 해시 테이블
    private V[] d = (V[]) new Object[M]; // key 관련 데이터 저장

    private int hash(K key) { //해시 함수
        return (key.hashCode() & 0x7fffffff) % M; //나눗셉 함수
    }
}
