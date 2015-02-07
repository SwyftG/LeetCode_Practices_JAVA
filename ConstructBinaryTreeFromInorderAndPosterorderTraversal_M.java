/***
  * Given inorder and postorder traversal of a tree, construct the binary tree.
  * 
  * Note:
  * You may assume that duplicates do not exist in the tree.
  * 
  * Hide Tags Tree Array Depth-first Search
  */



public class Solution {
	public static void main(String[] args) {
        
    }
    



	    public TreeNode buildTree(int[] inorder, int[] postorder) {
	        if (inorder.length != postorder.length) {
	        	return null;
	        } 
	        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	    }

	    public TreeNode buildTree(int[] inorder, int instart, int inend, int[] postorder, int posstart, int posend) {
	    	if (instart > inend) {
	    		return null;
	    	}
	    	TreeNode root = new TreeNode(postorder[posend]);
	    	int position = findPos(postorder[posend], inorder, instart, inend);
	    	root.left =	buildTree(inorder, instart, position - 1, postorder, posstart, posstart + position - instart - 1); 
	    	root.right = buildTree(inorder, position + 1, inend, postorder, posstart + position - instart, posend - 1);
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