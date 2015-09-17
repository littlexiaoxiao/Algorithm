package lintcode;

import java.util.*;

public class SubarraySum {
	public ArrayList<Integer> subarraySum(int[] nums) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (nums == null || nums.length == 0)
			return res;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum == 0) {
				res.add(0);
				res.add(i);
				return res;
			}
			if (map.containsKey(sum)) {
				res.add(map.get(sum) + 1);
				res.add(i);
				return res;
			} else {
				map.put(sum, i);
			}
		}
		return res;
	}
}
