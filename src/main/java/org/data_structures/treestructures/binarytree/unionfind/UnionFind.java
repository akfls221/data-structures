package org.data_structures.treestructures.binarytree.unionfind;

/**
 * 공통 원소를 갖지 않는 서로소 집합의 union과 find
 */
public class UnionFind {

    protected Node[] a;

    public UnionFind(Node[] a) {
        this.a = a;
    }

    protected int find(int i) {
        if (i != a[i].getParent()) {
            a[i].setParent(find(a[i].getParent()));
        }

        return a[i].getParent();
    }
}
