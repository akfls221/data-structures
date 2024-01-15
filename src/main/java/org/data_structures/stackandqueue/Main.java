package org.data_structures.stackandqueue;

import org.data_structures.stackandqueue.arraystack.ArrayStack;
import org.data_structures.stackandqueue.liststack.ListStack;

public class Main {
    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>();

        stack.push("test1");
        stack.push("test2");
        System.out.println("stack = " + stack);

        String peek = stack.peek();
        System.out.println("peek = " + peek);

        String pop = stack.pop();
        System.out.println("pop = " + pop);
        System.out.println("stack = " + stack);

        ListStack<String> stringListStack = new ListStack<>();
        stringListStack.push("test1");
        stringListStack.push("test2");
        System.out.println("stringListStack = " + stringListStack);

        String stringListPeek = stringListStack.peek();
        System.out.println("stringListPeek = " + stringListPeek);

        String stringListPop = stringListStack.pop();
        System.out.println("stringListPop = " + stringListPop);
        System.out.println("stringListStack = " + stringListStack);
    }
}
