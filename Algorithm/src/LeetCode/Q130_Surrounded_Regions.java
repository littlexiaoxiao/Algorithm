package LeetCode;
import java.util.LinkedList;


public class Q130_Surrounded_Regions {
	public static void main(String[] args) {
		char[][] board = new char[5][5];
		for(int i = 0; i < 5; i++) {
			for(int j =0; j< 5; j++) {
				if(i % 2 != 0) {
					board[i][j] = 'X';
				} else {
					board[i][j] = 'O';
				}
				board[2][1] = 'X';
				board[2][3] = 'X';
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();		
		solve(board);
		for(int i = 0; i < 5; i++) {
			for(int j =0; j< 5; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

    public static void solve(char[][] board) {
        //从边上的点出发，一直寻找所有连接的"O"
        //题目意思：从边上的O出发，寻找周围连接的‘0’，都改为“#“ 最后没有被改的”O“ 都要被替换成X
        if(board == null || board.length <= 1 || board[0].length <= 1)
            return;
        
        for(int i = 0; i < board[0].length; i++) {
            fill(board, 0, i); //第一行
            fill(board, board.length-1, i); // 最后一行
        }
        
        for(int i = 0; i < board.length; i++) {
            fill(board, i, 0); //第一列
            fill(board, i, board[0].length-1); //最后一列

        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] ='X';
                } else if (board[i][j] =='#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private static void fill(char[][] board,int i, int j ) {
        if(board[i][j] != 'O')
            return;
        
        board[i][j] = '#';
        int code = i * board[0].length + j;
        LinkedList<Integer> queue = new LinkedList<Integer>(); //先进先出
        queue.add(code);
        
        while(!queue.isEmpty()) {
            code = queue.poll();
            int row = code / board[0].length;
            int col = code % board[0].length;
            if(row >=1 && board[row-1][col] =='O'){ //正上方的元素
                code = (row -1) * board[0].length + col;
                queue.add(code);
                board[row-1][col] = '#';
            }
            
            if(row < board.length-1 && board[row +1][col] == 'O'){ //正下方的元素
                code = (row +1) *board[0].length + col;
                queue.add(code);
                board[row +1][col] = '#';
            }
            
            if(col >= 1 &&  board[row][col - 1] == 'O') {// 左边的元素
                code = row * board[0].length + (col-1);
                queue.add(code);
                board[row][col -1] = '#';
            }
            
            if(col < board[0].length-1 && board[row][col +1] == 'O') { //右边的元素
                code = row * board[0].length + (col +1);
                queue.add(code);
                board[row][col +1] = '#';
            }
        }
     }
}
