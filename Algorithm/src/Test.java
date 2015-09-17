import java.util.*;

public class Test{
	 public static void main(String[] args) {
		 System.out.println(Math.pow(2, 2.5));
		 System.out.println(Math.pow(2, 3.5));

	 }	 
	 public List<String> anagrams(String[] strs) {
	        List<String> res = new LinkedList<String>();
	        if(strs == null || strs.length == 0)
	            return res;
	        
	        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	        for(int i = 0; i < strs.length; i++) {
	            char[] chars = strs[i].toCharArray();
	            Arrays.sort(chars);
	            String str = new String(chars);
	            if(map.containsKey(str) ){
	                map.get(str).add(strs[i]);
	            } else {
	                map.put(str, new ArrayList<String>());
	                map.get(str).add(strs[i]);
	            }
	        }
	        
	        for(String s : map.keySet()) {
	            if(map.get(s).size() > 1) {
	                res.addAll(map.get(s));
	            }
	        }
	        return res;
	    }
}