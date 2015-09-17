package lintcode;

public class Longest_Palindromic_Substring {
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		String res = "";
		for (int i = 0; i < s.length(); i++) {
			String temp1 = longest(s, i, i);
			String temp2 = longest(s, i, i + 1);
			if (res.length() < temp1.length())
				res = temp1;
			if (res.length() < temp2.length())
				res = temp2;
		}
		return res;
	}

	private String longest(String str, int start, int end) {
		if (end < start) {
			return "";
		}
		while (start >= 0 && end <= str.length() - 1) {
			if (str.charAt(start) == str.charAt(end)) {
				start--;
				end++;
			} else {
				break;
			}
		}
		return str.substring(start + 1, end);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
