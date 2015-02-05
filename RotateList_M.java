/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 
 * Tags: Linked List, Two Pointers
 */


 public class Solution {
 	public static void main(String[] args) {
  
    }


	/**
     * Two pointers
     * Move fast pointer to the end of the list to get length
     * Move slow pointer to len - n % len to get the break point
     * Connect fast with head, update new head
     * Set slow.next to null to unlink the list
     */
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
        	return head;
        }
        ListNode pointer = head;
        int count = 0;
        while (pointer != null) {
        	pointer = pointer.next;
        	count++;
        }
        n = n % count;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode tail = dummy;

        for (int i = 0; i < n; i++) {
        	head = head.next;
        }
        while (head.next != null) {
        	head = head.next;
        	tail = tail.next;
        }
        head.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
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
