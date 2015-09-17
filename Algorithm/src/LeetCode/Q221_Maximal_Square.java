package LeetCode;

public class Q221_Maximal_Square {

	public static void main(String[] args) {
		char[][] matrix = new char[3][4];
		for(int i = 0; i< 3; i++) {
			for(int j =0; j < 4; j++){
				if(i %2 == 0) {
					matrix[i][j] ='1';
				} else {
					matrix[i][j] ='1';
				}
			}
		}
		int res = maximalSquare(matrix);
		System.out.println(res);
	}

    public static int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int max = 0;
        
        for(int i = 0; i < row; i++) {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(max, dp[i][0]);
        }
        
        for(int j =0; j < col; j++) {
            dp[0][j] = matrix[0][j] - '0';
            max = Math.max(max, dp[0][j]);
        }
        
        for(int i = 1; i < row; i++) {
            for(int j =1; j < col; j++) {
                if(matrix[i][j] != '0') {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}
