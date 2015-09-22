package Other_Interviews;

public class Reverse_String {
	public static String reverseString(String str) {
		if(str == null || str.length() == 0) {
			return str;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = str.length()-1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println("res = " + reverseString("abcd"));
	}

}
