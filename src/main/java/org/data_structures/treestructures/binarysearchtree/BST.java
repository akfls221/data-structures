package org.data_structures.treestructures.binarysearchtree;

public class BST <Key extends Comparable<Key>, Value> {
    public Node root;

    public BST(Key newId, Value newName) {
        this.root = new Node(newId, newName);
    }

    public Value get(Key key) {
        return this.get(this.root, key);
    }

    public void put(Key key, Value value) {
        this.root = this.put(this.root, key, value);
    }

    public Key min() {
        if (this.root == null) {
            return null;
        }

        return (Key) min(this.root).getKey();
    }

    public void deleteMin() {
        if (this.root == null) {
            System.out.println("empty tree");
        }
        this.root = this.deleteMin(this.root);
    }

    public void delete(Key key) {
        this.root = delete(this.root, key);
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

    public Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value);
        }

        int t = node.getKey().compareTo(key);

        if (t > 0) {
            node.setLeft(this.put(node.getLeft(), key, value));
        } else if (t < 0) {
            node.setRight(this.put(node.getRight(), key, value));
        } else {
            node.setValue(value);
        }

        return node;
    }

    private Node min(Node node) {
        if (node.getLeft() == null) {  //최솟값 이기때문에 왼쪽 서브트리일 수밖에 없다.(왼쪽 서브트리가 노드기준 작은값이기 때문)
            return node;    //null이라면 해당 null의 부모가 최솟값이 된다.
        }

        return min(node.getLeft());
    }

    private Node deleteMin(Node node) {
        if (node.getLeft() == null) {   //최솟값이라면(왼쪽 서브노드가 없다면 최솟값) 오른쪽 노드를 리턴
            return node.getRight();
        }

        node.setLeft(deleteMin(node.getLeft()));    //있다면, 왼쪽 서브노드를 계속 찾는다.(결국 오른쪽 노드를 return)

        return node;
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }

        int t = node.getKey().compareTo(key);
        if (t > 0) {
            node.setLeft(delete(node.getLeft(), key));
        } else if (t < 0) {
            node.setRight(delete(node.getRight(), key));
        } else {
            if (node.getRight() == null) {
                return node.getLeft();
            }

            if (node.getLeft() == null) {
                return node.getRight();
            }

            Node target = node;

            node = min(target.getRight());
            node.setRight(deleteMin(target.getRight()));
            node.setLeft(target.getLeft());
        }
        return node;
    }
}
