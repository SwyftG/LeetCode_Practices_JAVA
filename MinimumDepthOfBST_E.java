/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 * Tags: Tree, DFS
 */



public class Solution {
	public static void main(String[] args) {
        
    }
    

    /**
     * Recursive
     * Get minDepth of left and right subtree
     * If one side is 0, return the other side plus 1
     * Return the smaller one + 1
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        return minTree(root);
    }

    public int minTree(TreeNode root) {
    	if (root == null) {
    		return Integer.MAX_VALUE;
    	}
    	if (root.left == null && root.right == null) {
    		return 1;
    	}
    	return Math.min(minTree(root.left), minTree(root.right)) + 1;
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
