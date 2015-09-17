package Other_Interviews;
import java.util.Arrays;
import java.util.HashSet;

public class Remove_Duplicates {
	public static int[] removeDups(int[] arr) {
		if(arr == null || arr.length == 0) {
			return arr;
		}
		
        Arrays.sort(arr);
		int[] res = new int[arr.length];
		int count = arr.length-1;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < arr.length; i++) {
			if(!set.contains(arr[i])) {
				res[count] = arr[i];
				count--;
				set.add(arr[i]);
			}
		}	
        return Arrays.copyOfRange(res, count+1, arr.length);	
	}
	
	public static void main(String[] args) {
		int[] nums = {6,6,4,1,4,1,1,1,1,5,1,10};
		int[] res = removeDups(nums);
		for(Integer i : res) {
			System.out.print(i + ", ");
		}
	}
}
