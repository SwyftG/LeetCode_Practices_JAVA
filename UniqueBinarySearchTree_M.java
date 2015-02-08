/**
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1...n?
 * 
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * 
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * 
 * Tags: Tree, DP
 */



public class Solution {
 	public static void main(String[] args) {
        
    }


    
    /**
     * DP, Bottom-up approach.
     * a BST can be destruct to root, left subtree and right subtree.
     * if the root is fixed, every combination of unique left/right subtrees
     * forms a unique BST.
     * 
     * Let a[n] = number of unique BST's given values 1..n, then
     * a[n] = a[0] * a[n-1]     // put 1 at root, 2...n right
     *      + a[1] * a[n-2]     // put 2 at root, 1 left, 3...n right
     *      + ...
     *      + a[n-1] * a[0]     // put n at root, 1...n-1 left
     */
    public int numTrees(int n) {
        int[] count = new int[n + 2];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
        	for (int j = 0; j < i; j++) {
        		count[i] = count[i] + count[j] * count[i - j - 1];
        	}
        }
        return count[n];
    }
}