/**
 * Given a linked list, remove the nth node from the end of list and return its 
 * head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes 
 * 1->2->3->5.
 * 
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * 
 * Tags: Linked list, Two pointers
 */


 public class Solution {
	public static void main(String[] args) {
        
    }

    /**
     * Use a faster pointer to remoember the location
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if (head == null) {
    		return head;
    	}
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	head = dummy;
    	ListNode fast = dummy;
    	for (int i = 0; i < n; i++) {
    		fast = fast.next;
    	}
    	while (fast.next != null) {
    		fast = fast.next;
    		head = head.next;
    	}
    	head.next = head.next.next;
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