import java.util.ArrayList;
import java.util.List;


public class q54_Spiral_Matrix {

	public static void main(String[] args) {
		int[][] matrix = new int[5][5];
		spiralOrder(matrix);
		System.out.println(matrix.toString());
	}

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        
        if(matrix == null || matrix.length == 0) 
            return res;
        
        int colup = 0;
        int coldown = matrix.length-1;
        int rowleft = 0;
        int rowright = matrix[0].length -1;
        
        while(colup <= coldown && rowleft <= rowright) {
           
            for(int i = rowleft; i <= rowright; i++) {
                res.add(matrix[colup][i]);
            }
            colup ++;
            
            for(int i = colup; i <= coldown; i++) {
                res.add(matrix[i][rowright]);
            }
            rowright --;
            
            if(colup <= coldown) {
               for(int i = rowright; i >= rowleft; i--) {
                    res.add(matrix[coldown][i]);
                }
            }
            coldown --;
            
            if(rowleft <= rowright  ) {
               for(int i = coldown; i >= colup; i --) {
                    res.add(matrix[i][rowleft]);
                }
            }
            rowleft ++;
        }
        return res;
    }
}
