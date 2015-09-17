package lintcode;

public class Wildcard_Matching {
	public static boolean isMatch(String s, String p) {
		if (s == null)
			return false;

		int indexs = 0;
		int indexp = 0;
		int start = -1;
		int mark = -1;
		while (indexs < s.length()) {
			if (indexp < p.length()
					&& (s.charAt(indexs) == p.charAt(indexp) || p
							.charAt(indexp) == '?')) {
				indexs++;
				indexp++;
			} else if (indexp < p.length() && p.charAt(indexp) == '*') {
				start = indexp;
				mark = indexs;
				indexs++;
				indexp++;
			} else if (start != -1) {
				indexp = start;
				indexs = mark+1;
				mark++;
			} else {
				return false;
			}
			
			if(indexs == s.length() && indexp < p.length()) {
				while(indexp < p.length()) {
					if( p.charAt(indexp) == '*') {
						indexp++;
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "abcde";
		String p = "???????";
		System.out.println("s length = " + s.length());
		System.out.println("p length = " + p.length());
		System.out.println(isMatch(s, p));
	}
}
