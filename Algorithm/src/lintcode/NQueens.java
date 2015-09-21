package lintcode;

import java.util.ArrayList;

public class NQueens {
	ArrayList<ArrayList<String>> solveNQueens(int n) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if (n <= 0) {
			return res;
		}

		int[] queenRow = new int[n];
		dfs(res, queenRow, 0, n);
		return res;
	}

	private void dfs(ArrayList<ArrayList<String>> res, int[] queenRow, int row,
			int n) {
		if (row == n) {
			ArrayList<String> item = new ArrayList<String>();
			for (int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < n; j++) {
					if (queenRow[j] == i) {
						sb.append("Q");
					} else {
						sb.append(".");
					}
				}
				item.add(sb.toString());
			}
			res.add(new ArrayList<String>(item));
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
