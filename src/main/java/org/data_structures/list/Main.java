package org.data_structures.list;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        MyList<Integer> myList = MyList.of(1, 2);
        MyList<Integer> myList2 = MyList.of();
        System.out.println("myList = " + myList);
        System.out.println("myList2 = " + myList2);

    }
}
