package LeetCode;

public class Q43_Multiply_Strings {

	public static void main(String[] args) {
		 String res = multiply("131","222");
		 System.out.println(res);
	}

    public static String multiply(String num1, String num2) {
        if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0)
            return "";
        
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int[] res = new int[num1.length() + num2.length()];
        
        for(int i = 0; i < num1.length(); i++){
            int temp1 = num1.charAt(i) -'0';
            System.out.println("temp1= " + temp1);
            for(int j =0; j < num2.length(); j++) {
                int temp2 = num2.charAt(j) - '0';
                System.out.println("temp2= " + temp2);
                res[i+j] += temp1 * temp2;
                //System.out.println("res[i+j]= " + res[i+j]);
               // System.out.println();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < res.length; i++) {
            int digit = res[i] % 10;
            int carry = res[i] /10;
            sb.insert(0, digit);
            if(i < res.length-1) {
                res[i+1] += carry;
            }
        }
        
        while(sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
       
        if(sb.length() == 0){
        	return "0";
        }
        return sb.toString();
    }
}
