/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the
 * previous row.
 * 
 * For example,
 * 
 * Consider the following matrix:
 * 
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * 
 * Tags: Array, Binary Search
 */



public class Solution {
	public static void main(String[] args) {
        int[][] matrix = { {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(matrix, 0));
        System.out.println(searchMatrix(matrix, 1));
        System.out.println(searchMatrix(matrix, 2));
        System.out.println(searchMatrix(matrix, 11));
        System.out.println(searchMatrix(matrix, 15));
        System.out.println(searchMatrix(matrix, 34));
        System.out.println(searchMatrix(matrix, 35));
        System.out.println(searchMatrix(matrix, 50));
        System.out.println(searchMatrix(matrix, 51));
        System.out.println(searchMatrix(matrix, 100));
    }




	/**
     * Binary search to locate row, then binary search in a row
     * O(logm + logn)
     */
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int start = 0;
		int end = matrix.length - 1;
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (matrix[mid][0] == target) {
				return true;
			} else if (matrix[mid][0] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		if (start - 1 < 0 || start - 1 >= matrix.length) {
			return false;
		}
		int row = start - 1;
		start = 0;
		end = matrix[row].length - 1;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (matrix[row][mid] == target) {
				return true;
			} else if (matrix[row][mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}

	


    /**
     * n * m matrix convert to an array => matrix[x][y] => a[x * m + y]
     * an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];
     * 
     * disadvantage: 1. m * n may overflow 2. / and % are expensive
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        	return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = cow * row - 1;
        int mid;
        while (start <= end) {
        	mid = start + (end - start) / 2;
        	int digit = matrix[mid / col][mid % col];
        	if (digit == target) {
        		return true;
        	} else if (digit < target) {
        		start = mid + 1;
        	} else {
        		end = mid - 1;
        	}
        }
        return false;
    }
}