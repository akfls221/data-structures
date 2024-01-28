package org.data_structures.priorityqueue.huffman;

public class Entry {
    private int frequency; //빈도수
    private String word; // 이파리의 문자 또는 내부 노드의 합성된 문자열
    private Entry left; // 왼쪽 자식
    private Entry right; // 오른쪽 자식
    private String code; // 허프만 코드

    public Entry(int frequency, String word, Entry left, Entry right, String code) {
        this.frequency = frequency;
        this.word = word;
        this.left = left;
        this.right = right;
        this.code = code;
    }

    public int getFrequency() {
        return frequency;
    }

    public String getWord() {
        return word;
    }

    public Entry getLeft() {
        return left;
    }

    public Entry getRight() {
        return right;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
