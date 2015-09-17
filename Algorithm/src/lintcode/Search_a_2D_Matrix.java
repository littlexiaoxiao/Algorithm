package lintcode;

public class Search_a_2D_Matrix {
    public static int searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return 0;
        
        int res = 0;
        int col = matrix.length;
        int row = matrix[0].length;
        int i = 0;
        int j = row - 1;
        while(i >= 0 && i <  col && j >= 0 && j < row) {
            int cur = matrix[i][j];
            if(target == cur) {
                res++;
                i++;
                j--;
            } else if (target < cur) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }    
	public static void main(String[] args) {

	}
}
