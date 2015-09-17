package lintcode;

import java.util.Stack;

public class ImplementQueueWith_2stacks {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	public ImplementQueueWith_2stacks() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public void push(int element) {
		stack1.push(element);
	}

	public int pop() {
		if (stack2.isEmpty()) {
			if (stack1.isEmpty()) {
				throw new RuntimeException("Stack1 is empty");
			}
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	public int top() {
		if (stack2.isEmpty()) {
			if (stack1.isEmpty()) {
				throw new RuntimeException("Stack1 is empty");
			}
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
	}

	public static void main(String[] args) {
		ImplementQueueWith_2stacks test = new ImplementQueueWith_2stacks();
		for(int i = 2; i < 20; i++) {
			test.push(i);
		}
		
		System.out.println("top  " + test.top());
		
		for(int i = 0; i < 5; i++) {
			System.out.println("pop  " + test.pop());
		}
		//System.out.println("pop  " + test.pop());
		
	}
}
