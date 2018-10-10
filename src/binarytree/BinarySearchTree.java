package binarytree;

public class BinarySearchTree {

    void insertNode(Node nodeIn, int value) {
        if(value <= nodeIn.value) {
            if(nodeIn.leftNode == null) {
                nodeIn.leftNode = new Node(value);
            }
            else {
                insertNode(nodeIn.leftNode, value);
            }
        }
        else {
            if(nodeIn.rightNode == null) {
                nodeIn.rightNode = new Node(value);
            }
            else {
                insertNode(nodeIn.rightNode, value);
            }
        }
    }

    boolean searchNode(Node nodeIn, int value) {
        if(value < nodeIn.value && nodeIn.leftNode != null) {
            return searchNode(nodeIn.leftNode, value);
        }

        if(value > nodeIn.value && nodeIn.rightNode != null) {
            return searchNode(nodeIn.rightNode, value);
        }

        return nodeIn.value == value;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Node rootNode = new Node(15);
        bst.insertNode(rootNode, 10);
        bst.insertNode(rootNode, 7);
        bst.insertNode(rootNode, 8);
        bst.insertNode(rootNode, 9);
        bst.insertNode(rootNode, 12);

        System.out.println(bst.searchNode(rootNode, 15));
        System.out.println(bst.searchNode(rootNode, 10));
        System.out.println(bst.searchNode(rootNode, 7));
        System.out.println(bst.searchNode(rootNode, 8));
        System.out.println(bst.searchNode(rootNode, 9));
        System.out.println(bst.searchNode(rootNode, 12));
        System.out.println(bst.searchNode(rootNode, 0));
    }
}
