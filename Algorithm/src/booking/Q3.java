package booking;

import java.util.*;

/*
 * Problem 3:

Write a function get_hops_from(page1, page2) that will determine the number of hyperlinks 
that you would need to click on to get from some page1 on the web to some other page2 on the web.

For example, if each page below links to the pages that are indented below it,
e.g. page 1 links to pages 2 and 5, and page 2 links to pages 3 and 4, and page 5 links to pages 3 and 7, 
then the get_hops_from(page1, page7) should return 2 (2 hops), 
since you have to hop once from page 1 to 5 and once more from page 5 to page 7.


page1 :       distance == 0
    page2 :   distance == 1
      page3 : distance == 2
      page4 : distance == 2
    page5 :   distance == 2
      page3 : distance == 2
      page7 : distance == 2

Assume that an API is available to:
* get_links(a_page) will return an array/list of all pages that a_page links to
 */
public class Q3 {
	public static void main(String[] args) {
		Map<Integer, List<Integer> > graph = new HashMap<Integer, List<Integer> >();
		addEdge(1, 2, graph);
		addEdge(1, 5, graph);
		addEdge(2, 3, graph);
		addEdge(2, 4, graph);
		addEdge(5, 3, graph);
		addEdge(5, 7, graph);

		System.out.println(get_hops_from(graph, 1, 7));
	}
	
	//form a graph;
	public static void addEdge(int from, int to, Map<Integer, List<Integer> > graph){
		if(!graph.containsKey(from))
			graph.put(from, new ArrayList<Integer>());
		if(!graph.containsKey(to))
			graph.put(to, new ArrayList<Integer>());
		graph.get(from).add(to);
	}
	
	public static int get_hops_from(Map<Integer, List<Integer> > graph, int page1, int page2) {
		if(!graph.containsKey(page1) || !graph.containsKey(page2))
			return Integer.MAX_VALUE;
		Map<Integer, Integer> visited = new HashMap<Integer, Integer>();
		List<Integer> que = new LinkedList<Integer>();
		visited.put(page1, 0);
		que.add(page1);
		while(que.size() != 0){
			int p = que.remove(0);
			int dis = visited.get(p);
			List<Integer> adjacent = graph.get(p);
			for(Integer i : adjacent){
				if(visited.containsKey(i))
					continue;
				visited.put(i, dis + 1);
				if(i == page2)
					break;
				que.add(i);
			} 
		}
		if(visited.containsKey(page2))
			return visited.get(page2);
		return Integer.MAX_VALUE;
	}
}
