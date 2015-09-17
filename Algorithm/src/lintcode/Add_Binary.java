package lintcode;

public class Add_Binary {
	public String addBinary(String a, String b) {
		if (a == null || a.length() == 0) {
			return b;
		}
		if (b == null || b.length() == 0) {
			return a;
		}

		StringBuilder res = new StringBuilder();
		int maxlen = Math.max(a.length(), b.length());
		int carry = 0;
		int tempa = 0;
		int tempb = 0;

		for (int i = 0; i < maxlen; i++) {
			if (i < a.length()) {
				tempa = a.charAt(a.length() - i - 1) - '0';
			} else {
				tempa = 0;
			}

			if (i < b.length()) {
				tempb = b.charAt(b.length() - i - 1) - '0';
			} else {
				tempb = 0;
			}
			res.append((tempa + tempb + carry) % 2);
			carry = (tempa + tempb + carry) / 2;
		}

		if (carry != 0) {
			res.append(carry);
		}
		return res.reverse().toString();
	}
}
