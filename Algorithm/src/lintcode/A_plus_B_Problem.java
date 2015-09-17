package lintcode;

public class A_plus_B_Problem {

	public static void main(String[] args) {
		int res = aplusb(90,11);
		System.out.println("final res = " + res);
	}
	
    public static int aplusb(int a, int b) {
        if(b == 0) {
        	return a;
        }
		
        int sum = a^b; // just plus, no carry;
        int carry = (a&b) <<1; // carry
        return aplusb(sum, carry);
    }

}
