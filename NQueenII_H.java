/**
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of
 * distinct solutions.
 * 
 * Tags: Backtracking
 */



public class Solution {
	public static void main(String[] args) {
        System.out.println(totalNQueens(2));
        System.out.println(totalNQueens(3));
        System.out.println(totalNQueens(4));
        System.out.println(totalNQueens(5));
    }



    /**
     * DFS
     */
	private static int sum;
    public int totalNQueens(int n) {
    	sum = 0;
    	int[] usecol = new int[n];
    	helper(usecol, 0);
    	return sum;
    }

    public void helper(int[] usecol, int row) {
    	int n = usecol.length;
    	if (row == n) {
    		sum++;
    		return;
    	}
    	for (int i = 0; i < n; i++) {
    		if (isValid(usecol, row, i)) {
    			usecol[row] = i;
    			helper(usecol, row + 1);
    		}
    	}
    }

    public boolean isValid(int[] usecol, int row, int col) {
    	for (int i = 0; i < row; i++) {
    		if (usecol[i] == col) {
    			return false;
    		}
    		if ((row - i) == Math.abs(col - usecol[i])) {
    			return false;
    		}
    	}
    	return true;
    }
}