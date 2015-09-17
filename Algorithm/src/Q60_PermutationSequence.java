import java.util.*;


public class Q60_PermutationSequence {

	public static void main(String[] args) {
		getPermutation(3,4);

	}
	
    public static String getPermutation(int n, int k) {
        if(n <= 0 || k <= 0) {
            return "";
        }

        //create an array to store the numbers;        
        List<Integer> numbers = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++){
            numbers.add(i);
        }
        
        //get the (n-1)!
        int factorial = 1;
        for(int i =2; i< n; i++) {
            factorial = factorial * i;
        }
        
        k = k - 1;
        StringBuilder res = new StringBuilder();
        int round = n - 1;
        while(round >= 0) {
            int index = k / factorial;
            
            res.append(numbers.get(index));
            System.out.println(index);
            numbers.remove(index);
            
            if(round > 0) {
               	k =k %factorial;
            	factorial = factorial / round; 
            }
            round --;
        }
        
        return res.toString();
    }

}
