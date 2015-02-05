/**
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * 
 * Tags: Tree, BFS, Stack
 */


 public class Solution {
 	public static void main(String[] args) {
        
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
        	return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean left = true;
        while (!queue.isEmpty()) {
        	List<Integer> tmp = new ArrayList<Integer>();
        	int size = queue.size();
        	for (int i = 0; i < size; i++) {
        		TreeNode node = queue.poll();
        		tmp.add(node.val);
        		if (node.left != null) {
        			queue.offer(node.left);
        		}
        		if (node.right != null) {
        			queue.offer(node.right);
        		}
        	}
        	if (left) {
        		result.add(tmp);
        		left = false;
        	} else {
        		Collections.reverse(tmp);
        		result.add(tmp);
        		left = true;
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