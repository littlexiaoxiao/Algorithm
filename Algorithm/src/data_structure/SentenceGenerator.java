package data_structure;

import java.util.*;
import java.io.*;

//CMU 15121 homework_ hashmap
public class SentenceGenerator
{
//@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException
	{
		/* PHASE I:

		Read a file of words one line at a time and build a Map
		whose key is the first word on the line and
		whose value is a List of all subsequent words on that line

  			name;Fred;Bob;Mary
			verb;throws;eats;chases;breaks
			article;a;the;this
			adjective;big;red;small;blue
  			noun;wagon;ball;hot-dog
		*/
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		BufferedReader br = null;
		String[] strs  = null;
		try {
			String sCurrentLine = null;
			br = new BufferedReader(new FileReader("/Users/maojiewen/Desktop/data_structure/SentenceGenerator/substitutions.txt"));
			while ((sCurrentLine = br.readLine()) != null) {
				strs = sCurrentLine.split("\\;");
				ArrayList<String> list = new ArrayList<String>();
				for(int i = 1; i < strs.length; i++) {
					list.add(strs[i]);
				}
				map.put(strs[0], list);			
			}
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		/* PHASE II:

		Retrieve the keys from the HashMap and print the keys and associated words
		in sorted order one per line.

		Here is the expected output:

  		     Map (sorted alphabetically by Category and by Exemplars)

	        adjective can be replaced by [big, blue, red, small]
	        article can be replaced by [a, the, this]
	        noun can be replaced by [ball, hot-dog, wagon]
	        name can be replaced by [Bob, Fred, Mary]
	        verb can be replaced by [breaks, chases, eats, throws]
		*/
		List<String> list = new ArrayList(map.keySet());
		Collections.sort(list);
		for(int i = 0; i < map.size(); i++) {
			Collections.sort(map.get(list.get(i)));
			System.out.println(list.get(i) + " can be replaced by " + map.get(list.get(i).toString()));
		}
		
		/* PHASE III:
		Read a line of category words from a file and build a sentence by selecting one random exemplar.

		For example, the input file sentence.txt contains the following line:

		  name;verb;article;adjective;noun

		It indicates a name is to be followed by a verb, which is followed by an article, etc.
		*/

		BufferedReader br2 = null;
		String[] strs2  = null;
		String randomSentence = "";
		try {
			String sCurrentLine2 = null;
			br2 = new BufferedReader(new FileReader("/Users/maojiewen/Desktop/data_structure/SentenceGenerator/sentence.txt"));
			while ((sCurrentLine2 = br2.readLine()) != null) {
				strs2 = sCurrentLine2.split("\\;");
				for(int i = 0; i < strs2.length; i++) {
					int randomIndex = new Random().nextInt(map.get(strs2[i]).size());
					if(i == strs2.length -1){
						randomSentence += map.get(strs2[i]).get(randomIndex);
						break;
					}
					randomSentence += map.get(strs2[i]).get(randomIndex) + " ";	
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		randomSentence += ".";
		System.out.println(randomSentence);
	}

}
