/**
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical 
 * and the nodes have the same value.
 * 
 * Tags: Tree, DFS
 */


 public class Solution {
 	public static void main(String[] args) {
        
    }

    
 	/**
 	 * Iterative
 	 */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
        	return p == q;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val == q.val;
    }
    

    /**
     * One Stack solution
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	if (p == null && q == null) {
    		return true;
    	}
    	if (p == null || q == null) {
    		return false;
    	}
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	stack.push(q);
    	stack.push(p);
    	while (!stack.isEmpty()) {
    		TreeNode pNode = stack.pop();
    		TreeNode qNode = stack.pop();
    		if (pNode == null && qNode == null) {
    			continue;
    		}
    		if (pNode == null || qNode == null) {
    			return false;
    		}
    		if (pNode.val != qNode.val) {
    			return false;
    		}
    		stack.push(qNode.left);
    		stack.push(pNode.left);
    		stack.push(qNode.right);
    		stack.push(pNode.right);
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