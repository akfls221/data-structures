package org.data_structures.hashtable.closedaddressing.chaining;

public class Chaining<K, V> {
    private int M = 13; // 테이블 크기
    private Node[] a = new Node[M]; // 해시 테이블

    public static class Node {  // node class
        private Object key;
        private Object value;
        private Node next;

        public Node(Object key, Object value, Node ref) {
            this.key = key;
            this.value = value;
            this.next = ref;
        }

        public Object getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }
    }

    private int hash(K key) {   //해시 함수
        return (key.hashCode() & 0x7fffffff) % M;
    }

    /**
     * Chaining 방식 삽입
     *
     * @param key       삽입 키
     * @param value     삽입 값
     */
    public void put(K key, V value) {
        int i = hash(key); // 삽입하려는 hash값
        for (Node node = a[i]; node != null; node = node.next) {    //해당 해시에 있는 연결리스트를 순회하며 검색 없다면 맨앞에 삽입
            if (key.equals(node.key)) { //이미 key가 존재
                node.value = value; //데이터만 갱신
                return;
            }
        }
        a[i] = new Node(key, value, a[i]);  //연결 리스트 첫노드에 삽입
    }
}
