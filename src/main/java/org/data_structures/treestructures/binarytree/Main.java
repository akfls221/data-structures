package org.data_structures.treestructures.binarytree;

public class Main {

    public static void main(String[] args) {
        Node<String> rootNode = new Node<>("A", new Node<>("B", new Node<>("D", new Node<>("G", null, null), null), null), null);
        BinaryTree<String> keyBinaryTree = new BinaryTree<>();
        keyBinaryTree.setRoot(rootNode);

        System.out.println("중위순회");
        keyBinaryTree.inorder(rootNode);
        System.out.println("전위순회");
        keyBinaryTree.preorder(rootNode);


        Node<String> rootNode2 = new Node<>("A", new Node<>("B", new Node<>("D", new Node<>("G", null, null), new Node<>("H", null, null)), null), null);
        System.out.println("후위순회");
        keyBinaryTree.postOrder(rootNode2);

        System.out.println("레벨순회");
        keyBinaryTree.levelorder(rootNode2);

        System.out.println("size");
        keyBinaryTree.size(rootNode2);

        System.out.println("heigh");
        keyBinaryTree.height(rootNode2);
    }
}
