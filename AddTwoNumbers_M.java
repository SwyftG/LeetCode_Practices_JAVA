/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * Tags: Linkedlist, Math
 */


 public class Solution {
 	public static void main(String[] args) {

 	}


 	/**
     * Create a pre head pointer
     * Build list node one by one
     * Use sum to track the current sum of nodes, or node
     * Reset sum using sum /= 10
     * Note whether there is carry for last digit
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
        	return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
        	int sum = l1.val + l2.val + carry;
        	pointer.next =  new ListNode(sum % 10);
        	carry = sum / 10;
        	l1 = l1.next;
        	l2 = l2.next;
        	pointer = pointer.next;
        }
        while (l1 != null) {
        	int sum = l1.val + carry;
        	pointer.next = new ListNode(sum % 10);
        	carry = sum / 10;
        	l1 = l1.next;
        	pointer = pointer.next; 
        }
        while (l2 != null) {
        	int sum = l2.val + carry;
        	pointer.next = new ListNode(sum % 10);
        	carry = sum / 10;
        	l2 = l2.next;
        	pointer = pointer.next;
        }
        if (carry != 0) {
        	pointer.next = new ListNode(carry);
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