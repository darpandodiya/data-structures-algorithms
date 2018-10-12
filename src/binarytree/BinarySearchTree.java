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

    boolean deleteNode(Node nodeIn, Node parentNode, int value) {
        if(value < nodeIn.value && nodeIn.leftNode != null) {
            return deleteNode(nodeIn.leftNode, nodeIn,  value);
        }

        else if(value > nodeIn.value && nodeIn.rightNode != null) {
            return deleteNode(nodeIn.rightNode, nodeIn, value);
        }

        else if(value != nodeIn.value) {
            return false;
        }

        //When we find the node we are looking for to delete
        else {
            if(nodeIn.leftNode == null && nodeIn.rightNode == null && parentNode.leftNode == nodeIn) {
                parentNode.leftNode = null;
                nodeIn = null;
            }

            else if(nodeIn.leftNode == null && nodeIn.rightNode == null && parentNode.rightNode == nodeIn) {
                parentNode.rightNode = null;
                nodeIn = null;
            }

            else if(nodeIn.leftNode != null && nodeIn.rightNode == null && parentNode.leftNode == nodeIn) {
                parentNode.leftNode = nodeIn.leftNode;
                nodeIn = null;
            }

            else if(nodeIn.leftNode != null && nodeIn.rightNode == null && parentNode.rightNode == nodeIn) {
                parentNode.rightNode = nodeIn.leftNode;
                nodeIn = null;
            }

            else if(nodeIn.leftNode == null && nodeIn.rightNode != null && parentNode.leftNode == nodeIn) {
                parentNode.leftNode = nodeIn.rightNode;
                nodeIn = null;
            }

            else if(nodeIn.leftNode == null && nodeIn.rightNode != null && parentNode.rightNode == nodeIn) {
                parentNode.rightNode = nodeIn.rightNode;
                nodeIn = null;
            }

            else {
                nodeIn.value = findMinimumValue(nodeIn.rightNode);
                deleteNode(nodeIn.rightNode, nodeIn, nodeIn.value);
            }

            return true;
        }
    }

    int findMinimumValue(Node nodeIn) {
        if(nodeIn.leftNode != null) {
            return findMinimumValue(nodeIn.leftNode);
        }

        else {
            return nodeIn.value;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Node rootNode = new Node(15);
        bst.insertNode(rootNode, 10);
        bst.insertNode(rootNode, 20);
        bst.insertNode(rootNode, 8);
        bst.insertNode(rootNode, 12);
        bst.insertNode(rootNode, 17);
        bst.insertNode(rootNode, 25);
        bst.insertNode(rootNode, 19);

        System.out.println(bst.searchNode(rootNode, 15));
        System.out.println(bst.searchNode(rootNode, 12));
        System.out.println(bst.searchNode(rootNode, 9));
        System.out.println(bst.searchNode(rootNode, 0));

        bst.deleteNode(rootNode, null, 8);
        BinaryTree.preOrderTraveral(rootNode);
        System.out.println();

        bst.deleteNode(rootNode, null, 17);
        BinaryTree.preOrderTraveral(rootNode);
        System.out.println();

        bst.deleteNode(rootNode, null, 15);
        BinaryTree.preOrderTraveral(rootNode);
        System.out.println();

    }
}
