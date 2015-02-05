/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 *  1
 *   \
 *    2
 *   /
 *  3
 * return [1,3,2].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * Tags: Tree, HashTable, Stack
 */


 public class Solution {
 	public static void main(String[] args) {
        
    }

    /**
     * Two stack solution.
     * One for store TreeNode, thw other for store the count number
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
        	return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> countStack = new Stack<Integer>();
        stack.push(root);
        countStack.push(0);
        while (!stack.isEmpty()) {
        	TreeNode node = stack.pop();
        	int count = countStack.pop();
        	if (count == 1) {
        		result.add(node.val);
        	} else {
        		if (node.right != null) {
        			stack.push(node.right);
        			countStack.push(0);
        		} 
        		stack.push(node);
        		countStack.push(1);
        		if (node.left != null) {
        			stack.push(node.left);
        			countStack.push(0);
        		}
        	}
        }
        return result;
    }


	/**
     * One stack solution, O(n) Space
     * Use a stack to store TreeNodes
     * Go to left most and add each node
     * Pop the node from stack, add its value, and try to go right
     * Stop if stack is empty or node is null
     */
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	while (!stack.isEmpty() || root != null) {
    		if (root != null) {
    			stack.push(root);
    			root = root.left;
    		} else {
    			root = stack.pop();
    			result.add(root.val);
    			root = root.right;
    		}
    	}
    	return result;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}