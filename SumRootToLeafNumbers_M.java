/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 *   1
 *  / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 * 
 * Tags: Tree, DFS
 */


public class Solution {
 	public static void main(String[] args) {
        
    }



    /**
     * Recursive, DFS
     * Build a helper function to pass cur result
     * If its leaf node, just return the val
     * Otherwise, goes to left root first then right root with current value
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int sum) {
    	if (root == null) {
    		return 0;
    	}
    	if (root.left == null && root.right == null) {
    		return root.val + sum * 10;
    	}
    	return dfs(root.left, sum * 10 + root.val) + dfs(root.right, sum * 10 + root.val);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}