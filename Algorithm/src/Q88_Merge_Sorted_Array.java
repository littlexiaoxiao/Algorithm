
public class Q88_Merge_Sorted_Array {

	public static void main(String[] args) {
		int[] nums1 = new int[14];
		nums1[0] = 1;
		nums1[1] = 3;
		nums1[2] =4;
		nums1[3] =  45;
		nums1[4] = 50;
		nums1[5] = 91;
		int[] nums2 = {2,3,4,6,7,8,9,90};
		int m =6;
		int n = 8;
		merge(nums1, m, nums2, n);
		for(int i =0; i< nums1.length; i++){
			  System.out.print( i + "  "+ nums1[i]);
			  System.out.println();
		}
	}

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null && nums2 == null)
            return;
        
        if(nums2 == null || nums2.length == 0)
            return;
        
        int index1 = m-1;
        int index2 = n-1;
        int newindex = m+n -1;
        while(index1 >= 0 && index2 >=0) {
            if(nums1[index1] > nums2[index2]) {
                nums1[newindex] = nums1[index1];
                index1 --;
            } else {
                nums1[newindex] = nums2[index2];
                index2 --;
            }
          
            newindex--;
        }
        
        while(index1 >= 0) {
            nums1[newindex] = nums1[index1];
            index1 --;
            newindex--;
        }
        
        while(index2 >=0) {
             nums1[newindex] = nums2[index2];
             index2 --;   
             newindex --;
        }
    }
}
