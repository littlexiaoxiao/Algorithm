
public class Q26_RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {
		int[] nums = {1,1,1,1, 1,1,23,4,4,5,6565};
		removeDuplicates(nums);
	}
	
    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        if(nums.length == 1)
            return 1;
            
        int len = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                continue;
            } else {
            	nums[len + 1] =nums[i];
            	len ++;
            	
            }            
        }
      //  System.out.println(len+ 1);        
        return len + 1;
    }

}
