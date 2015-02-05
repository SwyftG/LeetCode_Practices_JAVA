/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a
 * constant space solution?
 *
 * Tags: Tree, DFS
 */


 public class Solution {
 	public static void main(String[] args) {

    }


	/**
     * Do inorder traversal to find those swapped nodes
     */
 	TreeNode first = null;
 	TreeNode second = null;
 	TreeNode last = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }


    public void inorder(TreeNode root) {
    	if (root == null) {
    		return;
    	}
    	inorder(root.left);
    	if (first == null && root.val < last.val) {
    		first = last;
    	}
    	if (first != null && root.val < last.val) {
    		second = root;
    	}
    	last = root;
    	inorder(root.right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}