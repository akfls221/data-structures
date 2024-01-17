package org.data_structures.treestructures.binarytree;

public class Main {

    public static void main(String[] args) {
        Node<String> rootNode = new Node<>("A", new Node<>("B", new Node<>("D", new Node<>("G", null, null), null), null), null);
        BinaryTree<String> keyBinaryTree = new BinaryTree<>();
        keyBinaryTree.setRoot(rootNode);

        keyBinaryTree.inorder(rootNode);
        keyBinaryTree.preorder(rootNode);


        Node<String> rootNode2 = new Node<>("A", new Node<>("B", new Node<>("D", new Node<>("G", null, null), new Node<>("H", null, null)), null), null);
        keyBinaryTree.postOrder(rootNode2);
    }
}
