package org.data_structures.binarysearchtree;

public class BST <Key extends Comparable<Key>, Value> {
    public Node root;

    public BST(Key newId, Value newName) {
        this.root = new Node(newId, newName);
    }

    public Value get(Key key) {
        return this.get(this.root, key);
    }

    public Value get(Node node, Key key) {
        if (node == null) { //다음 오른쪽 혹은 왼쪽 서브노드가 없으면 즉, 찾는 노드가 없으면 null 반환
            return null;
        }

        int t = node.getKey().compareTo(key);

        if (t > 0) {    //node의 id가 key 보다 크기때문에 왼쪽 서브트리탐색(노드 기준 왼쪽은 노드보다 작은 서브트리)
            return this.get(node.getLeft(), key);
        } else if (t < 0) { //node의 id가 key보다 작기때문에 오른쪽 서브트리 탐색(노드 기준 오른쪽은 노드보다 큰 서브트리)
            return this.get(node.getRight(), key);
        } else {    //같다면 바로 리턴
            return (Value) node.getValue();
        }
    }
}
