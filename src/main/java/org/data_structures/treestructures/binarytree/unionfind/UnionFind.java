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

    /**
     * rank 기반의 union 연산
     *
     * @param i 비교하려는 i root
     * @param j 비교하려는 j root
     */
    public void union(int i, int j) {
        int iroot = find(i);
        int jroot = find(j);

        if (iroot == jroot) {
            return;
        }

        // rank가 높은 루트가 승자가 된다.
        if (a[iroot].getRank() > a[jroot].getRank()) {
            a[jroot].setParent(iroot);
        } else if (a[iroot].getRank() < a[jroot].getRank()) {
            a[iroot].setParent(jroot);
        } else {
            //둘 중의 하나를 임의로 승자로 취급 -> rank 1증가
            a[jroot].setParent(iroot);
            int t = a[iroot].getRank() + 1;
            a[iroot].setRank(t);
        }
    }
}
