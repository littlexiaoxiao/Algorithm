package lintcode;

public class Number_of_Islands {
	public int numIslands(boolean[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == true) {
					fill(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}

	private void fill(boolean[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
			return;
		}
		if (grid[i][j] == true) {
			grid[i][j] = false;
			fill(grid, i + 1, j);
			fill(grid, i - 1, j);
			fill(grid, i, j + 1);
			fill(grid, i, j - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
