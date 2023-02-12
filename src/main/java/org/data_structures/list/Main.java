package org.data_structures.list;


public class Main {

    public static void main(String[] args) {
        MyList<Integer> myList = MyList.testOf(1, 2);
        myList.add(3, 2);

        System.out.println("myList = " + myList);

    }
}
