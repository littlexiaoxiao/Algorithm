package lintcode;

import java.util.LinkedList;
import java.util.List;

public class Print_Numbers_by_Recursion {
	 public static void main(String[] args)
	   {
		 LinkedList<Integer> list = numbersByRecursion(5);
		 for(Integer i : list) {
			 System.out.print(i + ", ");
		 }
	   }
	 
	   public static LinkedList<Integer> numbersByRecursion(int n) {
		   LinkedList<Integer> list = new LinkedList<Integer>();
	        if(n <= 0)
	            return list;
	        
	        helper(list, n, 1);
	        return list;
	    }
	    
	    private static void helper(List<Integer> list, int n, int depth) {
	        if(n < depth)
	            return;
	        //System.out.println("1-------");
	        if(depth == 1) {
	            for(int i = 1; i <= 9; i++) {
	                list.add(i);
	            }
	        } else {
	            int j = (int)Math.pow(10, depth-1);
	            int edge = (int)Math.pow(10, depth);
	            for(; j < edge; j++) {
	                list.add(j);
	            }
	        }
	        helper(list, n, depth+1);
	    }
}
