package org.data_structures.treestructures.redblacktree;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;
    private class Node {
        Key id;
        Value name;
        Node left;
        Node right;
        boolean color;  //부모 link의 색

        public Node(Key id, Value name, boolean color) {
            this.id = id;
            this.name = name;
            this.color = color;
            this.left = null;
            this.right = null;
        }
    }

    public Value get(Key key) {
        return this.get(this.root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) {
            return null;    //탐색 실패
        }

        int t = node.id.compareTo(key);
        if (t > 0) {    //왼쪽 서브트리에서 탐색
            return get(node.left, key);
        }

        if (t < 0) {    //오른쪽 서브트리에서 탐색
            return get(node.right, key);
        }

        return node.name;
    }

    private boolean isEmpty() {
        return this.root == null;
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;   //좌편향 레드 블랙 트리(LLRB)의 경우 root와 null은 Black이다.
        }

        return node.color == RED;
    }
}
