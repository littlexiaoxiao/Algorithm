package lintcode;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
	public int evalRPN(String[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i].equals("+") || nums[i].equals("-")
					|| nums[i].equals("*") || nums[i].equals("/")) {
				int temp1 = stack.pop();
				int temp2 = stack.pop();
				if (nums[i].equals("+")) {
					stack.push(temp1 + temp2);
				} else if (nums[i].equals("-")) {
					stack.push(temp2 - temp1);
				} else if (nums[i].equals("/")) {
					stack.push(temp2 / temp1);
				} else if (nums[i].equals("*")) {
					stack.push(temp2 * temp1);
				}
			} else {
				stack.push(Integer.parseInt(nums[i]));
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
