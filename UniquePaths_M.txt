/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 * 
 * Tags: Array, DP
 */


public class Solution {
	public static void main(String[] args) {
        System.out.println(uniquePaths(10, 20));
        System.out.println(uniquePaths(10, 20));
    }



	/**
     * DP, top-down approach
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
        	return 0;
        }
        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {
        	sum[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
        	sum[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
        	}
        }
        return sum[m - 1][n - 1];
    }




    /**
     * Math, Combination
     * Equivalent to choose n-1 to go down from m - 1 + n - 1
     * other steps will go right
     */
    public int uniquePaths(int m, int n) {
    	int k = m > n ? n : m;
    	int N = m + n - 2;
    	double res = 1;
    	for (int i = 1; i < k; i++) {
    		res *= N--;
    		res /= i;
    	}
    	return (int)res;
    }
}