
public class Q27_RemoveElement {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,67,23,100,11};
		removeElement(nums, 10);
	}
	
	// O(n)
    public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int count = 0;
        for(int i =0; i < nums.length; i++){
            if(nums[i] == val) {
                continue;
            } else {
                nums[count] = nums[i];
                count ++;
            }
        }
        //System.out.println(count);
        return count;
    }

}
