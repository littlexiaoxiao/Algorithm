package LeetCode;
public class Q80_RemoveDuplicatesfromSortedArray_ii {
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		
		removeDuplicates(nums);
		for(int i =0; i < nums.length; i++){
			System.out.println(nums[i]);			
		}
	}
	
//	public static int removeDuplicates2(int[] nums) {
//		int count = 0;
//		if(nums == null || nums.length <= 2)
//			return count;		
//		count = 2; 
//		for(int i = count; i < nums.length; i++) {
//			if(nums[i] != nums[count-2]) {
//				nums[count] = nums[i];
//				count ++;
//			} 		
//		}
//		System.out.println(count);
//		return count;
//	}
	
    public static int removeDuplicates(int[] nums) {
        if(nums.length <= 2) 
            return nums.length;
        
        int count = 2;
        for(int i = 2; i < nums.length; i++) {
            if(nums[i] != nums[count -2]) {
            	nums[count ] = nums[i];
            	System.err.println(nums[count]);
                count ++;
            }                           
        }
        System.err.println(count);
        return count;
    }
}
