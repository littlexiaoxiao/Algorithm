package lintcode;

public class Digit_Counts {

	public static void main(String[] args) {
		int res = digitCounts(1, 12);
		System.out.print("res = " + res);
	}
	
	 public static int digitCounts(int k, int n) {
	        if(k < 0 || n < 0)
	            return 0;
	        
	        int res = 0;
	        for(int i = 0; i <= n; i++) {
	           if(containsK(k, i)) {
	        	   System.out.print(i + ", ");
	               res++;
	           } 
	        }
	        return res;
	    }
	    
	 private static boolean containsK (int k, int num) {
	        String str = Integer.toString(num);
	        for(int i = 0; i < str.length(); i++) {
	            if(str.charAt(i) - '0' == k ){
	                return true;
	            }
	        }
	        return false;
	 }
}
