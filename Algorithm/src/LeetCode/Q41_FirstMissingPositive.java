package LeetCode;

public class Q41_FirstMissingPositive {

	public static void main(String[] args) {
		int[] nums = {0,0,1,1,2,2};
		int res = firstMissingPositive(nums);
		System.out.print(res);

	}
	
    public static int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 1;
        //o(n) 也不需要用Arrays.sort(nums);
        //原理：把 nums[0] = 1, nums[1] =2; nums[2] = 3排序起来。 如果存在 num[i] != i+1的话，则要返回 i+1 这个数
        //只关注 >0 的所有数（小于等于0的不关心）
        
        for(int i = 0; i< nums.length; i++) {
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1]  = nums[i];
                nums[i] = temp;
                i --;
                
            }
        }
        
        for(int i =0; i< nums.length; i++){
            if(nums[i] != i+1)
                return i+1;
        }
        return nums[nums.length-1] + 1;
    }
}
