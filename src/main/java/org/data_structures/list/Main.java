package org.data_structures.list;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        /**
         * MyList 생성 테스트
         */
        MyList<Integer> myList = MyList.testOf(1, 2);

        /**
         * MyList add(삽입) 테스트
         */
        myList.add(3, 2);

        /**
         * MyList delete(삭제) 테스트
         */
        myList.delete(1);

        /**
         * MyList get(조회) 테스트
         */
        myList.get(2);

    }
}
