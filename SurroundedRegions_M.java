/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by
 * 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * Tags: BFS
 */


public class Solution {
	public static void main(String[] args) {
        
    }
	

	

    public void solve(char[][] board) {
    	if (board == null || board.length == 0 || board[0].length == 0) {
    		return;
    	}    
    	int row = board.length;
    	int col = board[0].length;
    	Queue<Integer> queue = new LinkedList<Integer>();
    	for (int i = 0; i < row; i++) {
    		enqueue(board, queue, row, col, i, 0);
    		enqueue(board, queue, row, col, i, col - 1);
    	}
    	for (int i = 0; i < col; i++) {
    		enqueue(board, queue, row, col, 0, i);
    		enqueue(board, queue, row, col, row - 1, i);
    	}
    	while (!queue.isEmpty()) {
    		int cur = queue.poll();
    		int x = cur / col, y = cur % col;
    		if (board[x][y] == 'O') {
    			board[x][y] = 'E';
    		}
    		enqueue(board, queue, row, col, x, y + 1);
    		enqueue(board, queue, row, col, x + 1, y);
    		enqueue(board, queue, row, col, x - 1, y);
    		enqueue(board, queue, row, col, x, y - 1);
    	}
    	for (int i = 0; i < row; i++) {
    		for (int j = 0; j < col; j++) {
    			if (board[i][j] == 'E') {
    				board[i][j] = 'O';
    			} else if (board[i][j] == 'O') {
    				board[i][j] = 'X';
    			}
    		}
    	}
    }

    public void enqueue(char[][] board, Queue<Integer> queue, int row, int col, int x, int y) {
    	if (x >= 0 && x < row && y >= 0 && y < col && board[x][y] == 'O') {
    		queue.offer(x * col + y);
    	}
    }
}