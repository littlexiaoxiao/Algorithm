package lintcode;

import java.util.*;

public class Combinations {
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (n < k)
			return res;

		List<Integer> item = new ArrayList<Integer>();
		helper(res, item, n, k, 1);
		return res;
	}

	private static void helper(List<List<Integer>> res, List<Integer> item,
			int n, int k, int index) {
		if (item.size() == k) {
			res.add(new ArrayList<Integer>(item));
			return;
		}

		for (int i = index; i <= n; i++) {
			item.add(i);
			helper(res, item, n, k, i + 1);
			item.remove(item.size() - 1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> res = combine(4,2);
		for(List<Integer> item : res) {
			System.out.println(item.toString());
		}
	}

}
