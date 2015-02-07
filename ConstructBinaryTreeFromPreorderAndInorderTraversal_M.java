/**
 * Given preorder and inorder traversal of a tree, construct the binary tree
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * Tags: Tree, Array, DFS
 */



public class Solution {
	public static void main(String[] args) {
        
    }
    



 	/**
     * Get root in preorder and search root in inorder
     * Then find range for left subtree and right subtree
     * Recurse down to build subtrees and connect to root
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
        	return null;
        }
        return buildTree(preorder, 0, preorder.length - 1,inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
    	if (instart > inend) {
    		return null;
    	}
    	TreeNode root = new TreeNode(preorder[prestart]);
    	int position = findPos(preorder[prestart], inorder, instart, inend);
    	root.left = buildTree (preorder, prestart + 1, prestart + position - instart, inorder, instart, position - 1);
    	root.right = buildTree (preorder, prestart + position - instart + 1, preend, inorder, position + 1, inend);
    	return root;
    }
    
    public int findPos(int target, int[] inorder, int instart, int inend) {
    	for (int i = instart; i <= inend; i++) {
    		if (inorder[i] == target) {
    			return i;
    		}
    	}
    	return -1;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}