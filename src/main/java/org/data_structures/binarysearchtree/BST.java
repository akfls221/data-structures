package org.data_structures.binarysearchtree;

public class BST <Key extends Comparable<Key>, Value> {
    public Node root;

    public BST(Key newId, Value newName) {
        this.root = new Node(newId, newName);
    }
}
