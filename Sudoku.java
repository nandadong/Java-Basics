import java.util.*;
public class Sudoku {
	public static void main(String[] args) {
		char[][] board = {	{'.','.','.','.','5','.','.','1','.'},
							{'.','4','.','3','.','.','.','.','.'},
							{'.','.','.','.','.','3','.','.','1'},
							{'8','.','.','.','.','.','.','2','.'},
							{'.','.','2','.','7','.','.','.','.'},
							{'.','1','5','.','.','.','.','.','.'},
							{'.','.','.','.','.','2','.','.','.'},
							{'.','2','.','9','.','.','.','.','.'},
							{'.','.','4','.','.','.','.','.','.'}	};
		System.out.print(isValidSudoku(board) + "\n");
	}
	public static boolean isValidSudoku(char[][] board) {
		HashSet<Character> validChar = new HashSet<Character>();
		validChar.add('.');
		for (int i = 1; i < 10; i++) {
			validChar.add(Integer.toString(i).charAt(0));
		}
		for (int i = 0; i < 9; i++) {
			HashSet<Character> rowChar = new HashSet<Character>();
			HashSet<Character> colChar = new HashSet<Character>();
			for (int j = 0; j < 9; j++) {
				if (!validChar.contains(board[i][j])) {
					return false;
				}
				if (rowChar.contains(board[i][j]) && board[i][j] != '.') {
					return false;
				}
				rowChar.add(board[i][j]);
				if (colChar.contains(board[j][i]) && board[j][i] != '.') {
					return false;
				}
				colChar.add(board[j][i]);
			}
		}

		HashSet<Character> subbox1 = new HashSet<Character>();
		HashSet<Character> subbox2 = new HashSet<Character>();
		HashSet<Character> subbox3 = new HashSet<Character>();
		HashSet<Character> subbox4 = new HashSet<Character>();
		HashSet<Character> subbox5 = new HashSet<Character>();
		HashSet<Character> subbox6 = new HashSet<Character>();
		HashSet<Character> subbox7 = new HashSet<Character>();
		HashSet<Character> subbox8 = new HashSet<Character>();
		HashSet<Character> subbox9 = new HashSet<Character>();
		for (int i = 0; i < 3; i++) {
			
			for (int j = 0; j < 3; j++) {
				if (subbox1.contains(board[i][j]) && board[i][j] != '.') {
					return false;
				}
				subbox1.add(board[i][j]);
				if (subbox2.contains(board[i][j+3]) && board[i][j+3] != '.') {
					return false;
				}
				subbox2.add(board[i][j+3]);
				if (subbox3.contains(board[i][j+6]) && board[i][j+6] != '.') {
					return false;
				}
				subbox3.add(board[i][j+6]);
				if (subbox4.contains(board[i+3][j]) && board[i+3][j] != '.') {
					return false;
				}
				subbox4.add(board[i+3][j]);
				if (subbox5.contains(board[i+3][j+3]) && board[i+3][j+3] != '.') {
					return false;
				}
				subbox5.add(board[i+3][j+3]);
				if (subbox6.contains(board[i+3][j+6]) && board[i+3][j+6] != '.') {
					return false;
				}
				subbox6.add(board[i+3][j+6]);
				if (subbox7.contains(board[i+6][j]) && board[i+6][j] != '.') {
					return false;
				}
				subbox7.add(board[i+6][j]);
				if (subbox8.contains(board[i+6][j+3]) && board[i+6][j+3] != '.') {
					return false;
				}
				subbox8.add(board[i+6][j+3]);
				if (subbox9.contains(board[i+6][j+6]) && board[i+6][j+6] != '.') {
					return false;
				}
				subbox9.add(board[i+6][j+6]);
			}
		}
		return true;
	}
}