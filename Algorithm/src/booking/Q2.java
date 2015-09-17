package booking;

import java.util.*;

/*
 * Problem 2:
 Implement a function all_anagram_groups() that, given many input strings, will identify and group words that are anagrams of each other. 
 An anagram is word that is just a re-arrangement of the characters of another word, 
 like "reap" and "pear" and "a per" (whitespace is ignored). 
 But "pear" and "rep" are not, since "rep" does not have an "a". Also, "the" and "thee" are not anagrams, because "the" only has one "e". 

 Given this example input:

 [ "pear","dirty room","amleth","reap","tinsel","tesla","hamlet","dormitory","listen","silent" ]

 The output should be an array-of-arrays (or list-of-lists)

 [
 ["pear","reap"],
 ["dirty room","dormitory"],
 ["amleth","hamlet"],
 ["tinsel","listen","silent"],
 ["tesla"]
 ]
 */
public class Q2 {
	public static void main(String[] args) {
		String[] str = { "pear", "dirty room", "amleth", "reap", "tinsel",
				"tesla", "hamlet", "dormitory", "listen", "silent" };
	    all_anagram_groups(str);
	}

	public static List<List<String>> all_anagram_groups(String[] str) {
		List<List<String>> res = new ArrayList<List<String>>();

		if (str == null || str.length == 0)
			return res;

		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < str.length; i++) {
			char[] chars = str[i].replace(" ", "").toCharArray();
			Arrays.sort(chars); // 可以当做常数
			String sortedString = new String(chars);

			ArrayList<String> item;
			if (!map.containsKey(sortedString)) {
				item = new ArrayList<String>();
			} else {
				item = map.get(sortedString);
			}
			item.add(str[i]);
			map.put(sortedString, item);
		}

		for (ArrayList<String> item : map.values()) {
			if (item.size() >= 1) {
				res.add(item);
				//System.err.println(item.toString()); //for test;
			}
		}
		return res;
	}
}
