package lintcode;

public class Ugly_Number {

	public static void main(String[] args) {
		long res = kthPrimeNumber(23);
		System.out.println("res = " +res);
	}
	
	public static long kthPrimeNumber(int k) {
        if(k <= 0) {
            return 0;
        }
        
        long[] res = new long[k+1];
        res[0] = 1;
        int index3 = 0;
        int index5 = 0;
        int index7 = 0;
        for(int i = 1; i <= k; i++) {
            res[i] = Math.min(res[index3]*3, Math.min(res[index5]*5, res[index7]*7));
            if(res[i] == res[index3]*3) {
                index3++;
            }
            if(res[i] == res[index5]*5) {
                index5++;
            }
            if(res[i] == res[index7]*7) {
                index7++;
            }
        }
        return res[k];
    }
	
}
