public class GameOfLife {
	public static void main(String[] args) {
		int[][] board = {
			{1, 1, 1},
			{1, 1, 0},
			{1, 0, 1}
		};
		gameOfLife(board);
		for (int i = 0; i < board.length; i ++) {
			for (int j = 0; j < board[0].length; j ++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	public static void gameOfLife(int[][] board) {
		//use 2 bits to store the current state and next state.
		//[next state, current state]
		//01 -> 11, alive -> alive
		//00 -> 10, dead -> alive
		//use &1 to check current state and >> 1 to move to next state.
		for (int i = 0; i < board.length; i ++) {
			for (int j = 0; j < board[0].length; j ++) {
				int num = numOfLiveNeighbors(board, i, j);
				if ((board[i][j] & 1) == 1) {
					if (num == 2 || num == 3) board[i][j] = 0b11;
				} else if ((board[i][j] & 1) == 0) {
					if (num == 3) board[i][j] = 0b10;
				}
			}
		}

		for (int i = 0; i < board.length; i ++) {
			for (int j = 0; j < board[0].length; j ++) {
				board[i][j] >>= 1;
			}
			
		}

	}
	private static int numOfLiveNeighbors(int[][] board, int i, int j) {
		int num = 0;
		if (i > 0) {
			if (j > 0 && (board[i - 1][j - 1] & 1) == 1) num ++;
			if ((board[i - 1][j] & 1) == 1) num ++;
			if (j < board[0].length - 1 && (board[i - 1][j + 1] & 1) == 1) num ++;
		}
		if (j > 0 && (board[i][j - 1] & 1) == 1) num ++;
		if (j < board[0].length - 1 && (board[i][j + 1] & 1) == 1) num ++;
		if (i < board.length - 1) {
			if (j > 0 && (board[i + 1][j - 1] & 1) == 1) num ++;
			if ((board[i + 1][j] & 1) == 1) num ++;
			if (j < board[0].length - 1 && (board[i + 1][j + 1] & 1) == 1) num ++;
		}
		return num;
	}
}