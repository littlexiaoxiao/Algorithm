package Other_Interviews;

public class Largest_product {
	public static int MaximumProduct(int[] input) {
		 int max = input[0];
		 int res = 0;
		 for(int i = 1; i < input.length; i++) {			 
			 if(input[i] > max) {
				 res = Math.max(res, input[i] * max);
			 }
			 max = Math.max(max, input[i]);
		 }
		 return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,11,4,3,5,6,1};
		System.out.println(MaximumProduct(nums));
	}

}
