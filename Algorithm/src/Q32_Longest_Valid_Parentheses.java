import java.util.Stack;


public class Q32_Longest_Valid_Parentheses {

	public static void main(String[] args) {
		String s = "()(())";
		int res = longestValidParentheses(s);
		System.out.println(res);
	}
	
    public static int longestValidParentheses(String s) {
        if(s == null || s.length() <= 1)
            return 0;
        
        int max = 0;
        int start = 0;
        Stack<Integer> stack = new Stack<Integer>();
            
        for(int i =0; i < s.length(); i++) {
            if(s.charAt(i) =='(') {
                stack.push(i);
            } else if(s.charAt(i) ==')') {
                if(stack.isEmpty()) {
                     start = start +1;                   
                } else {
                	stack.pop();
                	if(stack.isEmpty()) {
                		max = Math.max(max, i-start +1);
                	} else {
                		max = Math.max(max, i- stack.peek());
                	}
                }
            }
        }
        return max;
    }

}
