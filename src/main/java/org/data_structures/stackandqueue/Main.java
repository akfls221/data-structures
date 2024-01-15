package org.data_structures.stackandqueue;

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
    }
}
