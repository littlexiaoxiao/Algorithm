
public class Q115Distinct_Subsequences {
	public static void main(String[] args) {
		int res = numDistinct("ccccc", "c");
		System.out.print(res);

	}
	public static int numDistinct(String s, String t) {
        int[][] res = new int[s.length() + 1][t.length() + 1];
        res[0][0] = 1;
        
        for(int i = 1; i <= t.length(); i++) {
            res[0][i] = 0;
        }
        
        for(int i = 1; i<= s.length(); i++) {
            res[i][0] = 1;
        }
        
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j<= t.length(); j ++) {
                res[i][j] = res[i-1][j];
                
                if(s.charAt(i-1) == t.charAt(j-1)){
                    res[i][j] += res[i-1][j-1];
                }
            }
        }
        return res[s.length()][t.length()];
	}
}
