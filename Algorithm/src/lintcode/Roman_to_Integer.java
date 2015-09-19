package lintcode;

public class Roman_to_Integer {
	public int romanToInt(String s) {
		if (s == null || s.length() == 0)
			return 0;

		int res = 0, temp = 0;
		for (int i = 0; i < s.length(); i++) {
			temp = getValue(s.charAt(i));
			if (i > 0 && getValue(s.charAt(i - 1)) < getValue(s.charAt(i))) {
				res = res + temp - 2 * getValue(s.charAt(i - 1));
			} else {
				res += temp;
			}
		}
		return res;
	}

	private int getValue(char roman) {
		int number = 0;
		switch (roman) {
		case 'I':
			number = 1;
			break;
		case 'V':
			number = 5;
			break;
		case 'X':
			number = 10;
			break;
		case 'L':
			number = 50;
			break;
		case 'C':
			number = 100;
			break;
		case 'D':
			number = 500;
			break;
		case 'M':
			number = 1000;
			break;
		}
		return number;
	}
}
