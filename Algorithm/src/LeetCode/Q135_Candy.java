package LeetCode;

public class Q135_Candy {

	public static void main(String[] args) {
		int[] ratings = {1,2,5,6,9,4,3};
		int res = candy(ratings);
		System.out.println(res);
	}

    public static int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)
            return 0;
        
        int[] leftmax = new int[ratings.length];
        int[] rightmax = new int[ratings.length];
        int res = 0;
        
        leftmax[0] = 1;
        for(int i = 1; i < leftmax.length; i++){
            if(ratings[i] > ratings[i-1]) 
                leftmax[i] = leftmax[i-1] + 1;
            else 
                leftmax[i] = 1;
            System.err.println("left" + leftmax[i]);
        }
        
        rightmax[rightmax.length - 1] = leftmax[leftmax.length -1];
        for(int i =rightmax.length-2; i>=0; i--) {
            if(ratings[i] > ratings[i + 1] )
                rightmax[i] = rightmax[i+1] + 1;
            else
                rightmax[i] = 1;
        }
        
        for(int i =0; i< ratings.length; i++) {
        	System.err.println("max "+ Math.max(rightmax[i], leftmax[i]));
            res += Math.max(rightmax[i], leftmax[i]);
            System.err.println("test"+i + "  "+res);
        }
        return res;
    }
}
