package lintcode;

public class NQueens2 {
	public int totalNQueens(int n) {
		if (n <= 0)
			return 0;

		int[] res = new int[1];
		int[] queenRow = new int[n];
		dfs(res, queenRow, 0, n);
		return res[0];
	}

	private void dfs(int[] res, int[] queenRow, int row, int n) {
		if (row == n) {
			res[0] += 1;
			return;
		} else {
			for (int i = 0; i < n; i++) {
				queenRow[row] = i;
				if (isValid(queenRow, row)) {
					dfs(res, queenRow, row + 1, n);
				}
			}
		}
	}

	private boolean isValid(int[] queenRow, int row) {
		for (int i = 0; i < row; i++) {
			if (queenRow[i] == queenRow[row]
					|| Math.abs(queenRow[row] - queenRow[i]) == row - i) {
				return false;
			}
		}
		return true;
	}
}
