/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Tags: Linkedlist
 */


public class Solution {
	public static void main(String[] args) {
		
	}



	/**
     * Recursive
     * the order of l1, l2 doesn't matter
     */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}




    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode dummy = new ListNode(0);
    	ListNode pointer = dummy;
    	while (l1 != null && l2 != null) {
    		if (l1.val > l2.val) {
    			pointer.next = l2;
    			l2 = l2.next;
    		} else {
    			pointer.next = l1;
    			l1 = l1.next;
    		}
    		pointer = pointer.next;
    	}
    	if (l1 != null) {
    		pointer.next = l1;
    	}
    	if (l2 != null) {
    		pointer.next = l2;
    	}
    	return dummy.next;
    }
}