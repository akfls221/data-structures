package org.data_structures.treestructures.binarytree;

/**
 * N : Node 노드
 * V : Visit 방문
 * L : Left 왼쪽
 * R : Right 오른쪽
 *
 * @param <Key>
 */
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
        if (node != null) {
            System.out.println("key = " + node.getKey());
            preorder(node.getLeft());
            preorder(node.getRight());
        }
    }

    /**
     * 중위 순회 방식(LNR / LVR)
     *
     * @param node rootNote를 인자로 전달하여 호출한다.
     */
    public void inorder(Node node) {
        if (node != null) {
            inorder(node.getLeft());
            System.out.println("key = " + node.getKey());
            inorder(node.getRight());
        }
    }
}
