package binarytree;

import java.util.LinkedList;
import java.util.Queue;


public class BinaryTree {

    static void insertLeftNode(Node inNode, int value) {
        //If left node is empty, add new one
        if(inNode.leftNode == null) {
            inNode.leftNode = new Node(value);
        }
        //Else relink
        else {
            Node lNode = new Node(value);
            lNode.leftNode = inNode.leftNode;
            inNode.leftNode = lNode;
        }
    }

    static void insertRightNode(Node inNode, int value) {
        if(inNode.rightNode == null) {
            inNode.rightNode = new Node(value);
        }
        else {
            Node rNode = new Node(value);
            rNode.rightNode = inNode.rightNode;
            inNode.rightNode = rNode;
        }
    }

    static void preOrderTraveral(Node inNode) {
        System.out.print(inNode.value + " ");

        if(inNode.leftNode != null) {
            preOrderTraveral(inNode.leftNode);
        }

        if(inNode.rightNode != null) {
            preOrderTraveral(inNode.rightNode);
        }
    }

    static void inOrderTraversal(Node inNode) {
        if(inNode.leftNode != null) {
            inOrderTraversal(inNode.leftNode);
        }

        System.out.print(inNode.value + " ");

        if(inNode.rightNode != null) {
            inOrderTraversal(inNode.rightNode);
        }
    }

    static void postOrderTraversal(Node inNode) {
        if(inNode.leftNode != null) {
            inOrderTraversal(inNode.leftNode);
        }

        if(inNode.rightNode != null) {
            inOrderTraversal(inNode.rightNode);
        }

        System.out.print(inNode.value + " ");
    }


    static void bfsTraversal(Node inNode) {
        Queue<Node> travelQueue = new LinkedList<>();

        travelQueue.add(inNode);

        while(!travelQueue.isEmpty()) {
            Node queueHead = travelQueue.remove();

            System.out.print(queueHead.value + " ");

            if(queueHead.leftNode != null) {
                travelQueue.add(queueHead.leftNode);
            }

            if(queueHead.rightNode != null) {
                travelQueue.add(queueHead.rightNode);
            }
        }
    }

    public static void main(String[] args) {
        testInsertion();
    }

    static void testInsertion() {
        Node rootNode = new Node(1);

        rootNode.leftNode = new Node(2);
        rootNode.leftNode.leftNode = new Node(3);
        rootNode.leftNode.rightNode = new Node(4);

        rootNode.rightNode = new Node(5);
        rootNode.rightNode.leftNode = new Node(6);
        rootNode.rightNode.rightNode = new Node(7);

        System.out.println("Pre Order");
        preOrderTraveral(rootNode);

        System.out.println("\nIn Order");
        inOrderTraversal(rootNode);

        System.out.println("\nPost Order");
        postOrderTraversal(rootNode);

        System.out.println("\nBFS");
        bfsTraversal(rootNode);
    }





}
