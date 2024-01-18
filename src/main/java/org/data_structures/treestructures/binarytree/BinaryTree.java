package org.data_structures.treestructures.binarytree;

import java.util.LinkedList;
import java.util.Queue;

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
     * 전위순회 방식(NLR / VLR) node -> 왼쪽 -> 오른쪽
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
     * 중위 순회 방식(LNR / LVR) 왼쪽을 다돌고 -> node -> 오른쪽
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

    /**
     * 후위 순회 방식(LRN / LRV) 왼쪽을 다돌고 -> 오른쪽을 다돌고 -> node
     *
     * @param node rootNode를 인자로 전달하여 호출한다.
     */
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.println("key = " + node.getKey());
        }
    }

    /**
     * 레벨 순회 방식  레벨 단위로 왼쪽부터 오른쪽으로 방문
     *
     * @param root   rootNode
     */
    public void levelorder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node t;
            t = queue.remove();
            System.out.println("key = " + t.getKey());

            if (t.getLeft() != null) {
                queue.add(t.getLeft());
            }

            if (t.getRight() != null) {
                queue.add(t.getRight());
            }
        }
    }

    /**
     * 사이즈의 경우 후순위 방식으로 가져온다.
     * 
     * @param node 루트노드
     * @return 노드의 전체 수
     */
    public int size(Node node) {
        if (node == null) {
            return 0;
        }
        
        return ((1 + size(node.getLeft())) + size(node.getRight()));
    }

    /**
     * 높이의 경우 후쉰위 방식으로 가져온다.
     *
     * @param node 루트노드
     * @return 트리의 최대 레벨
     */
    public int heigh(Node node) {
        if (node == null) {
            return 0;
        }

        return (1 + Math.max(heigh(node.getLeft()), heigh(node.getRight())));
    }
}
