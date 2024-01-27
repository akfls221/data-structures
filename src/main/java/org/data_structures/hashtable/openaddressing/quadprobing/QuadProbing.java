package org.data_structures.hashtable.openaddressing.quadprobing;

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
    public void put(K key, V value) {   //삽입 연산
        int initialpos = hash(key); //초기 위치
        int i = initialpos;
        int j = 1;  
        int loopLimit = 20; //저장 시도 횟수 제한

        do {
            if (a[i] == null) { //삽입 위치 발견
                a[i] = key; //key를 해시 테이블에 저장
                d[i] = value;   //key 관련 데이터 저장, 항목 수 1 증가
                N++;
                return;
            }

            if (a[i].equals(key)) { //이미 key 존재
                d[i] = value;   //value만 갱신
                return;
            }

            i = (initialpos + j * j++) % M; // 충돌시 다음 i의 위치
            loopLimit -= 1;

        } while (loopLimit > 0);
        System.out.println("삽입 실패");
    }

    /**
     * 조회 메서드
     * 
     * @param key 키
     * @return V 값
     */
    public V get(K key) {
        int initialpos = hash(key);
        int i = initialpos;
        int j = 1;
        int loppLimit = 20;     //탐색 시도 제한 횟수

        while (a[i] != null && loppLimit > 0) {
            if (a[i].equals(key)) { //탐색 성공
                return d[i];
            }

            i = (initialpos + j * j++) % M;
            loppLimit -= 1;
        }
        return null;    //탐색 실패
    }
}
