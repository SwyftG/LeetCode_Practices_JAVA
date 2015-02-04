/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 * The Sudoku board could be partially filled, where empty cells are filled
 * with the character '.'.
 *
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only
 * the filled cells need to be validated.
 *
 * Tags: Hashtable
 */

 public class Solution {
 	public static void main(String[] args) {
 		char[][] board = new char[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == 0 && j == 0) {
                    board[i][j] = '.';
                } else if (i == 0 && j != 0) {
                    board[i][j] = (char)('0' + j + 1);
                } else {
                    board[i][j] = '.';
                }
            }
        }
        printBoard(board);
        System.out.println(isValidSudoku(board));
 	}

 	/**
 	 * using a boolean[] to remember the number which has already in borad.
 	 */

    public boolean isValidSudoku(char[][] board) {
 		boolean[] visited = new boolean[9];
 		for (int i = 0; i < 9; i++) {
 			Arrays.fill(visited, false);
 			for (int j = 0; j < 9; j++) {
 				if (!isValid(board[i][j], visited)) {
 					return false;
 				}
 			}
 		}
 		for (int i = 0; i < 9; i++) {
 			Arrays.fill(visited, false);
 			for (int j = 0; j < 9; j++) {
 				if (!isValid(board[j][i], visited)) {
 					return false;
 				}
 			}
 		}
 		for (int i = 0; i < 9; i += 3) {
 			for (int j = 0; j < 9; j += 3) {
 				Arrays.fill(visited, false);
 				for (int k = 0; k < 9; k++) {
 					if (!isValid(board[i + k / 3][j + k % 3], visited)) {
 						return false;
 					}
 				}
 			}
 		}
 		return true;
    }
    public boolean isValid(char c, boolean[] visited) {
    	if (c == '.') {
    		return true;
    	}
    	int num = c - '0';
    	if (num < 1 || num > 9 || visited[num - 1] == true) {
    		return false;
    	}
    	visited[num - 1] = true;
    	return true;
    }

    public static void printBoard(char[][] board) {
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board.length; j++) {
    			System.out.print(board[i][j] + " ");
    		}
    		System.out.println();
    	}
    	System.our.println("--------------------");
    }
}