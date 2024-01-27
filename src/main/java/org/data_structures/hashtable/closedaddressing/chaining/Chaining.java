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

}
