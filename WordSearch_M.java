/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * For example,
 * Given board =
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * 
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 
 * Tags: Array, Backtracking
 */



public class Solution {
	public static void main(String[] args) {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E' ,'E'}
        };
        String word = "SEE";
        System.out.println(exist(board, word));
    }



    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
        	return false;
        }
        if (word == null || word.length() == 0) {
        	return true;
        }
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		if (board[i][j] == word.charAt(0)) {
        			boolean result = finder(board, word, i, j, 0);
        			if (result) {
        				return true;
        			}
        		}
        	}
        }
        return false;
    }

    public boolean finder(char[][] board, String word, int i, int j, int start) {
    	if (start == word.length()) {
    		return true;
    	}
    	if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start)) {
    		return false;
    	}
    	board[i][j] = '#';
    	boolean result = finder(board, word, i - 1, j, start + 1) || finder(board, word, i + 1, j, start + 1) || finder(board, word, i, j - 1, start + 1) || finder(board, word, i, j + 1, start + 1);
    	board[i][j] = word.charAt(start);
    	return result;
    }
}