package leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MergeTwoSortedLists_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode headNode = new ListNode(-1);
        ListNode tailNode = headNode;

        while(true) {
            if(l1 == null) {
                tailNode.next = l2;
                break;
            }

            if(l2 == null) {
                tailNode.next = l1;
                break;
            }

            if(l1.val < l2.val) {
                tailNode.next = l1;
                l1 = l1.next;
            }
            else {
                tailNode.next = l2;
                l2 = l2.next;
            }
            tailNode = tailNode.next;
        }

        return headNode.next;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        //printList(l1);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        //printList(l2);

        ListNode newList = new MergeTwoSortedLists_21().mergeTwoLists(l1, l2);
        printList(newList);

    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

