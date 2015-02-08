/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the
 * root node down to the farthest leaf node.
 *
 * Tags: Tree, DFS
 */


public class Solution {
	 public static void main(String[] args) {

    }


    /**
     * Recursive, O(n)
     * If tree is empty, return 0
     * Else
     *  Get the max depth of left subtree recursively
     *  Get the max depth of right subtree recursively
     *  Get the max of max depths of left and right subtrees and add 1 to it
     */
    public int maxDepth(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}    
    	return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

	public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}