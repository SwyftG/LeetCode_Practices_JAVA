/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up:
 * Could you do this in-place?
 * 
 * Tags: Array
 */

 public class Solution {
 	public static void main(String[] args) {

 	}


 	/**
 	 * 90 degree clockwise
 	 * first is turned by 45 degree.
 	 * second is turned by vertical direction
 	 */


    public void rotate(int[][] matrix) {
 		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
 			return;
 		}
 		int len = matrix.length;
 		for (int i = 0; i < len; i++) {
 			for (int j = 0; j < len - i; j++) {
 				swap(matrix, i, j, len - j - 1, len - i - 1);
 			}
 		}
 		for (int i = 0; i < len / 2; i++) {
 			for (int j = 0; j < len; j++) {
 				swap (matrix, i, j, len - i - 1, j);
 			}
 		}
    }


    /**
     * 90 degrees clockwise
     * The solution of the matrix's size is not n x n.
     */

    public void rotate(int[][] matrix) {
 		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
 			return;
 		}
 		int row = matrix.length;
 		int col = matrix[0].length;
 		for (int i = 0; i < row; i++) {
 			for (int j = 0; j < col - i; j++) {
 				swap(matrix, i, j, col - j - 1, row - i - 1);
 			}
 		}
 		for (int i = 0; i < row / 2; i++) {
 			for (int j = 0; j < col; j++) {
 				swap (matrix, i, j, row - i - 1, j);
 			}
 		}
    }


	/**
 	 * 90 degree anticlockwise
 	 * first is turned by vertical direction
 	 * second is turned by 45 degree.
 	 */

    public void rotate(int[][] matrix) {
 		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
 			return;
 		}
 		int len = matrix.length;
 		for (int i = 0; i < len / 2; i++) {
 			for (int j = 0; j < len; j++) {
 				swap (matrix, i, j, len - i - 1, j);
 			}
 		}
 		for (int i = 0; i < len; i++) {
 			for (int j = 0; j < len - i; j++) {
 				swap(matrix, i, j, len - j - 1, len - i - 1);
 			}
 		}
    }

    public void swap(int[][] matrix, int x, int y, int a, int b) {
    	int tmp = matrix[x][y];
    	matrix[x][y] = matrix[a][b];
    	matrix[a][b] = tmp;
    }
}