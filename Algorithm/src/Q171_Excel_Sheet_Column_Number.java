
public class Q171_Excel_Sheet_Column_Number {

	public static void main(String[] args) {
		String s= "BA";
		int res = titleToNumber(s);
		System.out.println(res);
	}

    public static int titleToNumber(String s) {
        if(s == null || s.length() == 0)
            return 0;
        //26进制 → 十进制 26^0, 26^1...
        String str = new StringBuilder(s).reverse().toString();
        System.out.println(str);
        int res = 0;
        for(int i = 0; i< str.length(); i++){
            res += Math.pow(26, i) * (str.charAt(i) -'A' + 1);
        }
        return res;
    }
}
