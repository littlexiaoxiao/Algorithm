package Other_Interviews;

import java.util.*;

public class Traverse {
	public static int traverse(int seq_len) {
		int index = 1;
		ArrayList<Integer> traverse = new ArrayList<Integer>();
		while(traverse.size() < seq_len) {
			traverse.add(index);
			traverse.add(2*traverse.size()+1);
			index += 2;
			if(index> seq_len) {
				index -= seq_len;
			}
		}
		int sum = 0;
		int count =0;
		for(int i = 0; i < traverse.size(); i++ ){
			System.out.print(traverse.get(i) + ", ");
		}
		System.out.println();
		for(int i = traverse.size()-1; i >= 0; i--){
			int temp = traverse.get(i);
			int temp2 = traverse.get(count);
			sum += ( temp2 * temp);
			count++;
		}
		return sum;
	}
	public static void main(String[] args) {
		System.out.println(traverse(7));
	}

}
