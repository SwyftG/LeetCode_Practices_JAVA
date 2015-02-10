/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * 
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * 
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 
 * Tags: Backtracking, Bit Manipulation
 */


public class Solution {
	public static void main(String[] args) {
        
    }


    /**
     * DFS
     */
    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();
        if (n <= 0) {
        	return result;
        }
        ArrayList<Integer> solution = new ArrayList<Integer>();
        dfs(result, solution, n);
        return result; 
    }

    public void dfs(List<String[]> result, ArrayList<Integer> solution, int n) {
    	if (solution.size() == n) {
    		result.add(drawBoard(solution));
    		return;
    	}
    	for (int i = 0; i < n; i++) {
    		if (!isValid(solution, i)) {
    			continue;
    		}
    		solution.add(i);
    		dfs(result, solution, n);
    		solution.remove(solution.size() - 1);
    	}
    }

    public boolean isValid(ArrayList<Integer> solution, int a) {
    	int row = solution.size();
    	for (int i = 0; i < row; i++) {
    		if (solution.get(i) == a) {
    			return false;
    		}
    		if (i - solution.get(i) == row - a) {
    			return false;
    		}
    		if (i + solution.get(i) == row + a) {
    			return false;
    		}
    	}
    	return true;
    }

    public String[] drawBoard(ArrayList<Integer> solution) {
    	String[] chaseBoard = new String[solution.size()];
    	for (int i = 0; i < solution.size(); i++) {
    		chaseBoard[i] = "";
    		for (int j = 0; j < solution.size(); j++) {
    			if (j == solution.get(i)) {
    				chaseBoard[i] += "Q";
    			} else {
    				chaseBoard[i] += ".";
    			}
    		}
    	}
    	return chaseBoard;
    }
}