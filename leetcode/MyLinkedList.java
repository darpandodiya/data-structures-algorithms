package leetcode;

/**
 * https://leetcode.com/problems/design-linked-list/
 */
public class MyLinkedList {

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node node = head;
        if(index == 0 && head != null) {
            return head.val;
        }
        while (index >=0 && node != null) {
            if(index == 0) {
                return node.val;
            }
            index--;
            node = node.next;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node prev = head;
        head = new Node(val);
        head.next = prev;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(head == null) {
            head = new Node(val);
        }
        else {
            Node node = head;

            while(node.next != null) {
                node = node.next;
            }

            node.next = new Node(val);
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index == 0) {
            addAtHead(val);
            return;
        }

        Node node = head;
        index--;
        while (index >= 0 && node != null) {
            if(index == 0) {
                Node newNode = new Node(val);
                newNode.next = node.next;
                node.next = newNode;
                return;
            }
            node = node.next;
            index--;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index == 0 && head != null) {
            head = head.next;
        }

        Node node = head;
        index--;
        while (index >= 0 && node.next != null) {
            if(index == 0) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
            index--;
        }
    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(5);
        obj.addAtHead(2);
        //obj.addAtTail(1);
        //obj.addAtIndex(2,2);
        //System.out.println(obj.get(0) + "" + obj.get(1) + "" + obj.get(2));
        obj.deleteAtIndex(1);
        int param_1 = obj.get(1);

        System.out.println(param_1);
    }
}
