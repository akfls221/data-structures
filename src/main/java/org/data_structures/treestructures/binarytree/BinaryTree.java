package org.data_structures.treestructures.binarytree;

public class BinaryTree<Key extends Comparable<Key>> {

    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * 전위순회 방식(NLR / VLR)
     *
     * @param node rootNote를 인자로 전달하여 호출한다.
     */
    public void preorder(Node node) {
        if (!isEmpty()) {
            System.out.println("key = " + node.getKey());
            preorder(node.getLeft());
            preorder(node.getRight());
        }
    }
}
