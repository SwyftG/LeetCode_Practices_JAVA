/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * Tags: DFS, Linked list
 */



public class Solution {



	
    public TreeNode sortedListToBST(ListNode head) {	
    	return helper(head, null);
    }

    public TreeNode helper(ListNode start, ListNode end) {
    	if (start == end) {
    		return null;
    	}
    	ListNode mid = start;
    	ListNode probe = start;
    	while (probe != end && probe.next != end) {
    		probe = probe.next.next;
    		mid = mid.next;
    	}
    	TreeNode root = new TreeNode(mid.val);
    	root.left = helper(start, mid);
    	root.right = helper(mid.next, end);
    	return root;
    }
}