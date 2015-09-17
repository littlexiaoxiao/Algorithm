package Other_Interviews;

public class CountAndSayABCD {
//Give a string, like aabbcc, then print out 2a2b2c
	public static String countAndSay(String str) {
		if(str == null || str.length() == 0) {
			return str;
		}
		int count = 1;
		char pre = str.charAt(0);
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == pre) {
				count++;
			} else {
				sb.append(count).append(pre);
				pre = str.charAt(i);
				count = 1;
			}
		}
		sb.append(count).append(pre);
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(countAndSay("aaaaabbcc"));
	}
}
