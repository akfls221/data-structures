package org.data_structures.treestructures.avltree;

public class Node<Key extends Comparable<Key>, Value> {
    private Key id;
    private Value name;
    private int height;
    private Node left;
    private Node right;

    public Node(Key id, Value name, int height) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.left = null;
        this.right = null;
    }

    private Node rotateRight(Node node) {
        Node x = node.left();
        node.left = x.right;
        x.right = node;

        node.height = tallerHeight(height(node.left), height(node.right)) + 1;
        x.height = tallerHeight(height(x.left), height(x.right)) + 1;

        return x;
    }

    private int tallerHeight(int nHeight, int xHeight) {
        return Math.max(nHeight, xHeight);
    }

    public Key key() {
        return id;
    }

    public Value value() {
        return name;
    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        }

        return (1 + Math.max(height(node.left), height(node.right)));
    }

    public Node left() {
        return left;
    }

    public Node right() {
        return right;
    }

    public void setKey(Key id) {
        this.id = id;
    }

    public void setValue(Value name) {
        this.name = name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
