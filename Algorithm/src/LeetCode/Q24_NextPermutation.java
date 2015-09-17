package LeetCode;

public class Q24_NextPermutation {

	public static void main(String[] args) {
		int[] nums = {1,3,2,4,6,5};
		nextPermutation(nums);
		for(int i  =0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	
    public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        
        //从右往左，找出第一个不是增长的数。标记下来为 “小L”
        //再从左往右，找出第一个比 L 大的数, 标记为“大B”
        //交换 “小L” 和 “大B” 的位置。 
        //再把 大“B” 之后的数全部 reverse
        int small = 0;
        for(int i = nums.length -1; i >= 1; i--) {
            if(nums[i - 1] < nums[i]) {
                small = i -1;
                System.out.println("small= " + small);
                break;
            }
        }
        if(small == 0 && nums[small] > nums[small+1]) {
        	 System.out.println("i am here= ");
        	reverse(nums, 0, nums.length - 1);
        	return;
        }
        
        int big = 0;
        for(int i = nums.length -1; i >= small; i--) {
            if(nums[i] > nums[small]) {
                big = i;
                System.out.println("big= " + big);
                break;
            }
        }
        
        System.out.println("out big= " + big);
        swap(nums, small, big);
        reverse(nums, small+1 , nums.length-1);
        
    }
    
    private static void swap(int[] nums, int cur, int next) {
        int temp = nums[cur];
        nums[cur] = nums[next];
        nums[next] = temp;
    }
    
    private static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start ++;
            end --;
        }
    }

}
