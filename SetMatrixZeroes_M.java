/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to
 * 0. Do it in place.
 *
 * Tags: Array
 */

 public class Solution {
 	public static void main(String[] args) {

 	}


 	/**
 	 * Using first col to remember which row has zero.
 	 */

    public void setZeroes(int[][] matrix) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    		return;
    	}
    	int m = matrix.length;
    	int n = matrix[0].length;
    	boolean[] iszero = new boolean[n];
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (matrix[i][j] == 0) {
    				iszero[j] = true;
    				matrix[i][0] = 0;
    			}
    		}
    	}
    	for (int i = 0; i < m; i++) {
    		if (matrix[i][0] == 0) {
    			for (int j = 0; j < n; j++) {
    				matrix[i][j] = 0;
    			}
    		}
    	}
    	for (int j = 0; j < n; j++) {
    		if (iszero[j]) {
    			for (int i = 0; i < m; i++) {
    				matrix[i][j] = 0;
    			}
    		}
    	}
    }
}