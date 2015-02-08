
/**
 * Given n, <strong>generate</strong> all structurally unique BST's (binary
 * search trees) that store values 1...n.
 * 
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below
 * 
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * 
 * Tags: Tree, DP, Backtracking
 */


public class Solution {
 	public static void main(String[] args) {
        
    }
    

    /**
     * 1..n is the in-order traversal for any BST with nodes 1 to n. 
     * if pick i-th node as root
     * the left subtree will contain elements 1 to (i-1)
     * and the right subtree will contain elements (i+1) to n. 
     * use recursive calls to get back all possible trees for left and right 
     * subtrees and combine them in all possible ways with the root.
     */
    public List<TreeNode> generateTrees(int n) {
    	return generate(1, n);
    }

    public ArrayList<TreeNode> generate(int start, int end) {
    	ArrayList<TreeNode> result = new ArrayList<TreeNode>();
    	if (start > end) {		// base case
    		result.add(null);
    		return result;
    	}
    	for (int i = start; i <= end; i++) {
    		ArrayList<TreeNode> left = generate(start, i - 1);
    		ArrayList<TreeNode> right = generate(i + 1, end);
    		for (TreeNode r : right) { // left is fine
    			for (TreeNode l : left) { // right is fine
    				TreeNode root = new TreeNode(i);
    				root.left = l;
    				root.right = r;
    				result.add(root);
    			}
    		}
    	}
    	return result;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; left = null; right = null}
    }
}