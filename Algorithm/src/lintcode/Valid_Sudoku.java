package lintcode;

import java.util.HashSet;

public class Valid_Sudoku {
	public boolean isValidSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9)
			return false;

		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] >= '1' && board[i][j] <= '9') {
					if (set.contains(board[i][j])) {
						return false;
					} else {
						set.add(board[i][j]);
					}
				}
			}
			set.clear();
		}

		for (int j = 0; j < board[0].length; j++) {
			for (int i = 0; i < board.length; i++) {
				if (board[i][j] >= '1' && board[i][j] <= '9') {
					if (set.contains(board[i][j])) {
						return false;
					} else {
						set.add(board[i][j]);
					}
				}
			}
			set.clear();
		}

		for (int i = 0; i < board.length; i = i + 3) {
			for (int j = 0; j < board[0].length; j = j + 3) {
				for (int m = i; m < i + 3; m++) {
					for (int n = j; n < j + 3; n++) {
						if (board[m][n] >= '1' && board[m][n] <= '9') {
							if (set.contains(board[m][n])) {
								return false;
							} else {
								set.add(board[m][n]);
							}
						}
					}
				}
				set.clear();
			}
		}
		return true;
	}
}
