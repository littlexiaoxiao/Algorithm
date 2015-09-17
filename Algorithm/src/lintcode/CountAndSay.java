package lintcode;

public class CountAndSay {
	public static String countAndSay(int n) {
		if (n <= 0)
			return null;

		StringBuilder sb = new StringBuilder();
		StringBuilder res = new StringBuilder();
		sb.append(1);
		res = new StringBuilder();
		for (int i = 2; i <= n; i++) {
			int count = 1;
			res = new StringBuilder();
			for (int j = 1; j < sb.length(); j++) {
				if (sb.charAt(j) == sb.charAt(j - 1)) {
					count++;
				} else {
					res.append(count).append(sb.charAt(j - 1));
					count = 1;
				}
			}
			res.append(count).append(sb.charAt(sb.length() - 1));
			sb = res;			
		}
		return res.toString();
	}
	public static void main(String[] args) {
		String s = countAndSay(5);
		System.out.println(s);
	}

}
