/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 * Tags: Tree, DFS
 */


public class Solution {
	public static void main(String[] args) {
        
    }
    



    /**
     * Substract root value from sum every time
     * Return leaf node with sum == 0 
     * Or result in left subtree or right subtree
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
        	return false;
        }
        if (root.left == null && root.right == null) {
        	return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}