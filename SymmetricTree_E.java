/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * For example, this binary tree is symmetric:
 * 
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 
 * But the following is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * 
 * Tags: Tree, DFS, Stack
 */


 public class Solution {
 	public static void main(String[] args) {

 	}

 	/**
 	 * Iterative
 	 */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
        	return true;
        }
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
    	if (left == null && right == null) {
    		return true;
    	}
    	if (left == null || right == null) {
    		return false;
    	}
    	return helper(left.left, right.right) && helper(left.right, right.left) && left.val == right.val;
    }


    /**
     * Use a stack to store nodes in order
     * Then pop and compare
     */
    public boolean isSymmetric(TreeNode root) {
    	if (root == null) {
    		return true;
    	}
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	stack.push(root.left);
    	stack.push(root.right);
    	while (!stack.isEmpty()) {
    		TreeNode right = stack.pop();
    		TreeNode left = stack.pop();
    		if (right == null && left == null) {
    			continue;
    		}
    		if (right == null || left == null || right.val != left.val) {
    			return false;
    		}
    		stack.push(left.left);
    		stack.push(right.right);
    		stack.push(left.right);
    		stack.push(right.left);
    	}
    	return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}