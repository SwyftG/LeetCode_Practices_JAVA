
/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * Tags: Tree, DFS
 */


 public class Solution {
 	public static void main(String[] args) {

    }


    /**
     * Modification of max depth
     * If current node is null, return 0
     * Compare left depth with right depth
     * If the difference is bigger than 1, set isBalance false
     * Otherwise go on to the rest of the nodes
     */
    public boolean isBalanced(TreeNode root) {
        return rec(root) != -1;
    }

    public int rec(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	int right = rec(root.right);
    	int left = rec(root.left);
    	if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
    		return -1;
    	}
    	return Math.max(left, right) + 1;
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}