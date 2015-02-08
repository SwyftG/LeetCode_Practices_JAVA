/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the
 * node's key.
 * The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * Tags: Tree, DFS
 */


public class Solution {


	/**
     * Inorder traversal, generate a list, should be increasing order
     */
 	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}   
		List<Integer> result = new ArrayList<Integer>();
		inorder(root, result);
		for (int i = 0; i < result.size() - 1; i++) {
			if (result.get(i) >= result.get(i + 1)) {
				return	false;
			}
		}
		return true;
    }
    public void inorder(TreeNode root, List<Integer> result) {
    	if (root == null) {
    		return;
    	}
    	inorder(root.left, result);
    	result.add(root.val);
    	inorder(root.right, result);
    }








    public boolean isValidBST(TreeNode root) {
    	if (root == null) {
    		return true;
    	}    
    	if (root.left == null && root.right == null) {
    		return true;
    	}
    	return check(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public boolean check(TreeNode root, int max, int min) {
    	if (root == null) {
    		return true;
    	}
    	if (root.val > max || root.val < min) {
    		return false;
    	}
    	if (root.val == Integer.MAX_VALUE && root.right != null) {
    		return false;
    	}
    	if (root.val == Integer.MIN_VALUE && root.left != null) {
    		return false;
    	}
    	return check(root.left, root.val - 1, min) && check(root.right, max, root.val + 1);
    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}