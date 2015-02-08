/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *
 * return
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * Tags: Tree, DFS
 */



public class Solution {
	public static void main(String[] args) {

    }




	/**
     * DFS or backtracking
     * Note that we can't pass path directly 
     * Dereference before recursing
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
        	return result;
        }
        List<Integer> solution = new ArrayList<Integer>();
       	helper (result, solution, root, sum);
       	return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> solution, TreeNode root, int sum) {
    	if (root == null) {
    		return;
    	}
    	sum = sum - root.val;
    	if (root.left == null && root.right == null) {
    		if (sum == 0) {
    			solution.add(root.val);
    			result.add(new ArrayList<Integer>(solution));
    			solution.remove(solution.size() - 1);
    		}
    	}
    	solution.add(root.val);
    	helper(result, solution, root.left, sum);
    	helper(result, solution, root.right, sum);
    	solution.remove(solution.size() - 1);
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}