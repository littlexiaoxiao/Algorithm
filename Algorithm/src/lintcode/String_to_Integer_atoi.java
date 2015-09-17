package lintcode;

public class String_to_Integer_atoi {

	public static void main(String[] args) {
		String str = "    -5211314";
		int res = atoi(str);
		System.out.println("res = " + res);
	}

	public static int atoi(String str) {
		if (str == null || str.length() == 0)
			return 0;

		int res = 0;
		int start = 0;
		boolean isNegative = false;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '-') {
				sb.append('-');
				isNegative = true;
			} else if (str.charAt(i) == '+') {
				sb.append('+');
			} else if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
				start = i;
				break;
			}
		}
		if (sb.length() > 1) {
			return 0;
		}

		for (int i = start; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				continue;

			if (str.charAt(i) == '.')
				break;

			if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
				int temp = str.charAt(i) - '0';
				if ((isNegative == true && (Integer.MAX_VALUE - temp) / 10 < res))
					return Integer.MIN_VALUE;

				if ((Integer.MAX_VALUE - temp) / 10 < res)
					return Integer.MAX_VALUE;
				res = res * 10 + temp;
			} else {
				break;
			}
		}

		if (isNegative) {
			return -res;
		} else {
			return res;
		}
	}
}
