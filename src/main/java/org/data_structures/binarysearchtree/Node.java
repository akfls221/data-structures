package org.data_structures.binarysearchtree;

public class Node <Key extends Comparable<Key>, Value> {

    private Key id;
    private Value name;
    private Node left;
    private Node right;

    public Node(Key newId, Value newName) {
        this.id = newId;
        this.name = newName;
        this.left = null;
        this.right = null;
    }

    public Key getId() {
        return id;
    }

    public Value getName() {
        return name;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setId(Key id) {
        this.id = id;
    }

    public void setName(Value name) {
        this.name = name;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
