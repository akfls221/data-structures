package org.data_structures.treestructures.redblacktree;

/**
 *좌편향 RedBlackTree
 * red/black tree simulate
 * <a>https://www.cs.usfca.edu/~galles/visualization/RedBlack.html</a>
 * https://code-lab1.tistory.com/62(블로그)
 *
 * @param <Key>
 * @param <Value>
 */
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

    public void put(Key key, Value value) {
        this.root = this.put(this.root, key, value);
        this.root.color = BLACK;
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

    /**
     * 좌편향 RedBlackTree의 삽입
     * 
     * @param node 기준 Node
     * @param key   삽입할 노드의 Key
     * @param value 삽입할 노드의 value
     * @return node  모든 과정을 거쳐 삽입된 Node
     */
    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, RED);   //새로 추가되는 노드는 항상 RED
        }

        int t = key.compareTo(node.id);
        if (t < 0) {    //key가 비교 노드보다 작은경우 왼쪽에 put
            node.left = put(node.left, key, value);
        }

        if (t > 0) {    //key가 비교 노드보다 큰 경우 오른쪽에 put
            node.right = put(node.right, key, value);
        }

        node.name = value;  //k가 트리에 있는 경우 value만 갱신

        if (!isRed(node.left) && isRed(node.right)) {   // 오른쪽 자식이 red 이고 왼쪽 자식이 black일 경우 rotateLeft
            node = rotateLeft(node);
        }

        if (isRed(node.left) && isRed(node.left.left)) {    // 왼쪽 자식과 왼쪽 손자가 연속하여 레드일 때 rotateRight
            node = rotateRight(node);
        }

        if (isRed(node.left) && isRed(node.right)) {    //왼쪽 오른쪽 자식이 모두 red 인경우 flipColors
            flipColors(node);
        }

        return node;
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return null;
        }

        if (!isRed(node.left) && !isRed(node.left.left)) {
            node = moveRedLeft(node);
        }
        node.left = deleteMin(node.left);
        return fixUp(node);
    }

    /**
     * 좌편향 레드블랙 트리의 규칙을 위반하지 않는 상태를 유지하기 위해 아래 두 가지 방법으로 레드 link를 왼쪽 아래로 내려 보낸다.
     * <b>궁극적으로 삭제되는 노드를 레드로 만든 후에 삭제한다</b>
     *
     * case 1 : n.left 와 n.left.left가 모두 블랙이고, 동시에 n.right.left도 블랙이면 flipColors(node)를 실행한다.
     * case 2 : n.left와 n.left.left가 모두 블랙이고, 동시에 n.right.left가 레드이면 n.right.left의 레드 link를 왼쪽방향으로 보낸다.
     *
     * @param node
     * @return
     */
    private Node moveRedLeft(Node node) {
        flipColors(node);

        if (isRed(node.left.right)) {
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
            flipColors(node);
        }

        return node;
    }

    /**
     * 레드 블랙 트리 규칙에 어긋난 부분을 수정한다.
     *
     * @param node
     * @return
     */
    private Node fixUp(Node node) {
        if (isRed(node.right)) {
            node = rotateLeft(node);
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }

        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    /**
     * 노드의 오른쪽 레드 Link를 왼쪽으로 옮기는 연산
     *
     * @param node
     * @return  x 변경된 node
     */
    private Node rotateLeft(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;

        return x;
    }

    /**
     * 노드의 왼쪽 레드 Link를 오른쪽으로 옮기는 연산
     * 
     * @param node
     * @return x 변경된 node
     */
    private Node rotateRight(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;

        return x;
    }

    /**
     * 색변환 연산
     * 
     * @param node
     */
    private void flipColors(Node node) {
        node.color = !node.color;
        node.left.color = !node.left.color;
        node.right.color = !node.right.color;
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
