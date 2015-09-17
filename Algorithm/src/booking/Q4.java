package booking;

import java.util.*;

/*
 * Problem 4:

Implement a function sort_numerically() that will receive a list of numbers represented in English words 
and return the listed sorted by their numeric value, starting with the largest.

Input:

[
    "seventy five",                                                                                                     
    "two hundred forty one",                                                                                           
    "three thousand",                                                                                          
    "one million thirty five thousand twelve",
    "twenty", 
    "five hundred thousand",
    "two hundred", 
]

Output:
 
[
  "one million thirty five thousand twelve",
  "five hundred thousand"
  "three thousand",
  "two hundred forty one",
  "two hundred",
  "seventy five",
  "twenty",
]
 */
public class Q4 {
	public static void main(String[] args) {
		String[] strs = { "seventy five",                                                                                                     
						  "two hundred forty one",                                                                                           
						  "three thousand",                                                                                          
						  "minus one million thirty five thousand twelve",
						  "minus twenty", 
						  "five hundred thousand",
			    		  "two hundred"};
		
//		List<String> res= sort_numerically(strs);
//		for(int i = 0 ; i< res.size(); i++) {
//			System.out.println(res.get(i));
//		}
	}

	public static List<String> sort_numerically(String[] strs) {
		List<String> res = new ArrayList<String>();
		if(strs == null || strs.length == 0) 
			return res;
		
		List<CompareWords> resCompareWords = new ArrayList<CompareWords>();
		for(int i =0; i < strs.length; i++) {
			CompareWords wordnext = new CompareWords();
			wordnext.setNum(strs[i]);
			wordnext.setWord(strs[i]);
			resCompareWords.add(wordnext);				
		}	
		
		Collections.sort(resCompareWords);	
		for(int i = 0 ; i< resCompareWords.size(); i++) {
			res.add(resCompareWords.get(i).getWord());
		}
		return res;		
	}
}

	class CompareWords implements Comparable {
		private int num;
		private String word;
		
		public int getNum() {
			return num;
		}
		
		public String getWord(){
			return word;
		}
		
		public void setNum(String word){
			this.num = wordToNumber(word);
		}
		
		public void setWord(String word) {
			this.word = word;
		}
		
		//compare two words
		public int compareTo(Object o) {
			CompareWords cmp = (CompareWords) o;
			return cmp.compareTo(num);
		}
		
		public int compareTo(int number) {
			if(this.num == number) {
				return 0;
			} else if(this.num > number) {
				return 1;
			} else {
				return -1;
			}
		}
		// convert word to number;
		public static int wordToNumber (String str) {
			int res = 0;
			
			String[] units =  {
			        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
			        "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
			        "sixteen", "seventeen", "eighteen", "nineteen"};
			
			String[] tens = { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

		    String[] scales = { "hundred", "thousand", "million", "billion", "trillion" };

		    HashMap<String, ScaleIncrementPair> numberWords = new  HashMap<String, ScaleIncrementPair>();
		    
		    numberWords.put("minus", new ScaleIncrementPair(0,0));
		    for(int i = 0; i < units.length; i++) {
		    	numberWords.put(units[i], new ScaleIncrementPair(1, i));
		    }
		    
		    for(int i = 0; i < tens.length; i++) {
		    	numberWords.put(tens[i], new ScaleIncrementPair(1,((i + 2) * 10)));
		    }
		    
		    for(int i = 0; i < scales.length; i++) {
		    	if(i == 0) {
		    		numberWords.put(scales[i], new ScaleIncrementPair(100, 0));
		    	} else {
		    		numberWords.put(scales[i], new ScaleIncrementPair((int) Math.pow(10, (i*3)), 0));
		    	}	    	
		    }
	    
		    String[] splitWords = str.split(" ");
		    int cur = 0;
		    for(int i = 0; i < splitWords.length; i++) {
		    	if(splitWords[i].equals("and")) 
		    		continue;

		    	ScaleIncrementPair scaleIncrement = numberWords.get(splitWords[i]);
		    	cur = cur * scaleIncrement.scale + scaleIncrement.increment * scaleIncrement.scale;
		    	if(scaleIncrement.scale > 100) {
		    		res += cur;
		    		cur = 0;
		    	}
		    }
		    if(splitWords[0].equals("minus")) {
		    	//System.out.println(-(res+cur));
		    	return -(res+cur);
		    } else {
		    	//System.out.println(res + cur);
		    	return res + cur;
		    }
		}
	}
	
	class ScaleIncrementPair {
		public int scale;
		public int increment;
		public ScaleIncrementPair(int s, int i) {
			this.scale = s;
			this.increment = i;
		}
	}
		

