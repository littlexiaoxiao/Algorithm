import java.util.LinkedList;


public class Q150Evaluate_Reverse_Polish_Notation {

	public static void main(String[] args) {
		String[] tokens = {"2","3","*","+","+"};
		int res = evalRPN(tokens);
		System.out.println(res);

	}

    public static int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)
            return 0;
        
        int res = 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(int i =0; i < tokens.length; i++) {
            res = 0;
            if(tokens[i] == "*" || tokens[i] == "-" || tokens[i] == "+" || tokens[i] == "/" ) {
                int a = stack.pop();
                int b = stack.pop();
                
                if(tokens[i] == "*") {
                    res += a * b;
                } else if (tokens[i] == "/") {
                	if(a == 0 )
                		return 0;
                    res += b / a;
                } else if (tokens[i] == "+"){
                    res += a + b;
                } else if (tokens[i] == "-") {
                    res += b-a;
                }
                 stack.push(res);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

}
