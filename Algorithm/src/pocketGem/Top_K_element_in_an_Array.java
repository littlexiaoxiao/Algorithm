package pocketGem;
import java.util.*;
public class Top_K_element_in_an_Array {
	public static void main(String[] args) {
		int[] A = {1,2,2,3,3,3,3,4,4,4,4,5,5,5,5,5};
		List<Integer> res = findKTop (A, 2);
		
		for(Integer num : res) {
			System.out.println(num);
		}
	}
	
	public static class Element {
		int value;
		int frequency;
		Element(Integer v, Integer f) {
			value = v;
			frequency = f;
		}
	}	
	
	public static List<Integer> findKTop(int[] nums, int k) {
		List<Integer> res = new ArrayList<Integer>();
		if(nums == null || nums.length ==0)
			return res;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}
		List<Element> list = new ArrayList<Element>();
		Iterator iter = map.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry pair = (Map.Entry)iter.next();
			Element ele = new Element((Integer)pair.getKey(), (Integer)pair.getValue());
			list.add(ele);
		}
		
		PriorityQueue<Element> queue = new PriorityQueue<Element>(k+1, new myComparator());
		for(Element e : list) {
			queue.offer(e);
			if(queue.size() >= k+1)
				queue.poll();
		}
		
		for(Element e : queue) 
			res.add(e.value);
		
		return res;		
	}
	
	public static class myComparator implements Comparator<Element> {
		@Override
		public int compare(Element e1, Element e2) {
			return e1.frequency - e2.frequency;
		}		
	}
}
