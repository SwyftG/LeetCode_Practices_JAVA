/**
 * Given a binary tree, find the maximum path sum.
 *
 * The path may start and end at any node in the tree.
 *
 * For example:
 * Given the below binary tree,
 *
 *        1
 *       / \
 *      2   3
 * Return 6.
 *
 * Tags: Tree, DFS
 */


public class Solution {
	public static void main(String[] args) {

    }


    /**
     * Post order traversal
     */
 	public int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	int l = dfs(root.left);
    	int r = dfs(root.right);
    	int sum = root.val;
    	if (l > 0) {
    		sum += l;
    	}
    	if (r > 0) {
    		sum += r;
    	}
    	max = Math.max(max, sum);
    	int side = Math.max(l, r);
    	return side > 0 ? side + root.val : root.val;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}