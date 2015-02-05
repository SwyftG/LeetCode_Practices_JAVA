/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * 
 * Tags: Linkedlist
 */



 public class Solution {
 	public static void main(String[] args) {

 	}


 	/**
     * create a node at before the head
     * swap two next nodes on the node before them
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null && head.next.next != null) {
        	ListNode tmp = head.next.next.next;
        	head.next.next.next = head.next;
        	head.next = head.next.next;
        	head.next.next.next = tmp;
        	head = head.next.next;
        }
        return dummy.next;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}