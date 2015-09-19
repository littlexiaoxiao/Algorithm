package lintcode;

public class Integer_to_Roman {
	public String intToRoman(int n) {
		String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
		int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			for (int i = 0; i < value.length; i++) {
				if (n >= value[i]) {
					sb.append(roman[i]);
					n = n - value[i];
					break;
				}
			}
		}
		return sb.toString();
	}
}
