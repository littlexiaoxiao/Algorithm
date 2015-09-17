package lintcode;

public class Plus_One {
	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return null;
		}
		if (digits[digits.length - 1] < 9) {
			digits[digits.length - 1] += 1;
			return digits;
		}
		int[] res = new int[digits.length + 1];
		res[digits.length] = digits[digits.length - 1] + 1;
		int carry = 0;
		if (res[digits.length] >= 10) {
			carry = 1;
			res[digits.length] = res[digits.length] - 10;
		}

		for (int i = digits.length - 2; i >= 0; i--) {
			res[i + 1] = digits[i] + carry;
			if (res[i + 1] >= 10) {
				carry = 1;
				res[i + 1] -= 10;
			} else {
				carry = 0;
			}
		}
		if (carry == 1) {
			res[0] = 1;
			return res;
		}

		for (int i = 0; i < digits.length; i++) {
			digits[i] = res[i + 1];
		}
		return digits;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
