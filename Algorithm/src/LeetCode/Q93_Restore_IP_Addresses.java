package LeetCode;
import java.util.ArrayList;


public class Q93_Restore_IP_Addresses {

	public static void main(String[] args) {
		String s = "9245587303";
		ArrayList<String> res = restoreIpAddresses(s);
		//System.out.println(res.toString());
		
	}

    // 一个有效的IP地址由4个数字组成，每个数字在0-255之间。
    //对于其中的2位数或3位数，不能以0开头
    public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0)
            return res;
        
        String item = new String();
        helper(s, 0, item, res);
        System.out.println(res.toString());
        return res;
    }
    
    private static void helper(String s, int start, String item, ArrayList<String> res) {
    	if(start == 3 && isValid(s)) {
            res.add(item + s);     
            return;
        }
        
        for(int i = 0; i < 3 && i < s.length()-1; i++) {
            String str = s.substring(0, i+1);
            if(isValid(str)) {
            	//item = item + str +".";
            	System.out.println(item);
            	//String substring = s.substring(i+1, s.length()); 
                helper(s.substring(i+1, s.length()), start+1, item + str +"." , res);
            }
        }
    }
    
    private static boolean isValid(String str) {
        if(str == null )
            return false;
       
        if(str.charAt(0) =='0')
            return str.equals("0");
        
        int num = Integer.parseInt(str);
        if(num <= 255 && num > 0)
            return true;
       
        return false;
    }
}
