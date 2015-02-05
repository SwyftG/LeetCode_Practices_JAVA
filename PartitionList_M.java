/**
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * 
 * Tags: Linkedlist, Two Pointers
 */


public class Solution {
	public static void main(String[] args) {
        
    }


	/**
     * Build left and right lists and concatenate
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
        	return head;
        }
        ListNode leftNode = new ListNode(0);
        ListNode rightNode = new ListNode(0);
        ListNode left = leftNode;
        ListNode right = rightNode;
        while (head != null) {
        	if (head.val < x) {
        		left.next = head;
        		left = left.next;
        	} else {
        		right.next = head;
        		right = right.next;
        	}
        	head = head.next;
        }
        right.next = null;
        left.next = rightNode.next;
        return leftNode.next;
    }


	/**
     * Move greater and equal value nodes to tail
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
        	return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        ListNode start = dummy;
        while (pointer != null && pointer.next != null) {
        	if (pointer.next.val >= x) {
        		pointer = pointer.next;
        	} else { // move smaller nodes to start
        		if (pointer == start) { // don't forget the edge cases when p == start
        			start = start.next;
        			pointer = pointer.next;
        		} else {
        			ListNode tmp = pointer.next;  // move to start
        			pointer.next = tmp.next;
        			tmp.next = start.next;
        			start.next = tmp;
        			start = tmp; // don't forget to move start.
        		}
        	}
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