package org.data_structures.list;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        MyList<Integer> myList = MyList.testOf(1, 2);
        System.out.println("myList = " + myList);
        System.out.println("first element = " + myList.get(0));

    }
}
