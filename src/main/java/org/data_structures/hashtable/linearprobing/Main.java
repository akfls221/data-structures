package org.data_structures.hashtable.linearprobing;

public class Main {
    public static void main(String[] args) {

        LinearProbing<String, Integer> linearProbing = new LinearProbing<>();
        linearProbing.put("test", 25);
        linearProbing.put("test2", 37);
        linearProbing.put("test3", 18);
        linearProbing.put("test4", 55);
        Integer out = linearProbing.get("test2");
        System.out.println("out = " + out);
        System.out.println("linearProbing = " + linearProbing);
    }
}
