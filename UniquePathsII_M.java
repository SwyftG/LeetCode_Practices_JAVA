/**
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * 
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * 
 * Note: m and n will be at most 100.
 * 
 * Tags: Array, DP
 */



public class Solution {
	public static void main(String[] args) {
        int[][] board = new int[3][3];
        board[1][1] = 1;
        System.out.println(uniquePathsWithObstacles(board));
    }



 	/**
     * DP, bottom-up approach
     * build from end point to start point
     * for the grid paths at the rth row and cth column
     * paths[r][c] = obstacleGrid[r][c] == 1 ? 0 
     * : paths[r + 1][c] + paths[r][c + 1];
     */
    public int uniquePathsWithObstacles(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
        	return 0;
        }
        int m = board.length;
        int n = board[0].length;
        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {
        	if (board[i][0] == 1) {
        		break;
        	} else {
        		sum[i][0] = 1;
        	}
        }
        for (int i = 0; i < n; i++) {
        	if (board[0][i] == 1) {
        		break;
        	} else {
        		sum[0][i] = 1;
        	}
        }
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		if (board[i][j] == 1) {
        			sum[i][j] = 0;
        		} else {
        			sum[i][j] = sum[i - 1][j] + sum[i][j - 1];	
        		}
        	}
        }
        return sum[m - 1][n - 1];
    }
}