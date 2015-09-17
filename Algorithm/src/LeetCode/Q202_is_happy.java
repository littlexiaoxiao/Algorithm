package LeetCode;
import java.util.HashSet;


public class Q202_is_happy {

	public static void main(String[] args) {
		System.out.println(isHappy(2));
	}
	
    public static boolean isHappy(int n) {
        //对 n 不断取余，得到个位，十位，百位...
        int res = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        while(n != 0) {
            int temp = n % 10;
            n = n / 10;
            res +=  Math.pow(temp,2);
            System.out.println(res);
            if(n == 0) {
                if(set.contains(res)) {
                    return false;
                } else if( res == 1) {
                    return true;
                } else {
                   set.add(res);
                   n = res;
                   res =0;
                }
            }
        }
        return true;
    }

}
