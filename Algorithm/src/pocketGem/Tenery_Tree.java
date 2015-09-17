package pocketGem;	
	import java.util.*;
	/*
	Question 2
	==========
	Ex 1: "a?b:c"
	         a
	      b    c
	      
	Ex 2: "a?b?c:d:e"
	         a
	    b        e
	  c   d
	Ex 3: "a?b:c?d:e"
	          a
	    b            c
	               d   e
	class Node
	{
	  Node left, right;
	  char value;
	}
	Write a function which, given a ternary expression string input, parses it into the correct tree and returns the root node of that tree.
	Assumptions:
	How to convert a ternary expression to binary search tree 
	1. All inputs are valid ternary expressions.
	2. Every node value is a single letter (alphabet), symbols include ? and : only.
	Node parseExpression(String input);
	*/
	public class Tenery_Tree {
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			String str = "a?b:c?d?e:f:g";
//			str = "a?b?c:d:e";
//			str = "a?b:c?d:e";
//			str = "a?b?d:e:c?f:g";
			inorderTraversal(BuildTeneryTree(str));
		}

		/*
		*	Iterative Version
		*/
		//遇到？ 表示是做孩子， ：表示为右孩子
		public static Node BuildTeneryTree(String str) {
			if(str == null || str.length() == 0)
				return null;
			
			str = str.trim();
			Node root = new Node(str.charAt(0));
			Node cur = root;
			Stack<Node> stack = new Stack<Node>();
			for(int i = 1; i < str.length(); i = i+2) {
				char c = str.charAt(i);
				if(c == '?'){
					cur.left = new Node(str.charAt(i+1));
					stack.push(cur);
					cur = cur.left;
				} else {
					stack.peek().right = new Node(str.charAt(i+1));
					cur = stack.pop().right;
				}
			}
			return root;
		}

		public static void inorderTraversal(Node root) {
			ArrayList<Character> result = new ArrayList<Character>();
			Stack<Node> stack = new Stack<Node>();
			Node cur = root;
			while(cur != null || !stack.isEmpty()) {
				if(cur != null) {
					stack.push(cur);
					cur = cur.left;
				} else {
					Node temp = stack.pop();
					result.add(temp.val);
					cur = temp.right;
				}
			}
			for (char s : result) {
				System.out.print(s);
			}
		}
	
	public static class Node {
		char val;
		Node left;
		Node right;
		Node(char v) {
			val = v;
			left = null;
			right = null;
		}
	}

}
