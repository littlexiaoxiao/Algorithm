package lintcode;

public class Minimum_Path_Sum {
    public static int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        
        int col = grid.length;
        int row = grid[0].length;
        int[][] dp = new int[col][row];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < col; i++) {
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        
        for(int j = 1; j < row; j++) {
            dp[0][j] = grid[0][j] + dp[0][j-1];
        }
        
        for(int i = 1; i < col; i++) {
            for(int j = 1; j < row; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[col-1][row-1];
    }
    
	public static void main(String[] args) {
		int[][] grid = new int[3][3];
		int[] list = {1,3,1,1,5,1,4,2,1};
		int count = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				grid[i][j] = list[count];
				count ++;
			}
		}	
		int res = minPathSum(grid);
		System.out.println("res = " + res);
	}

}
