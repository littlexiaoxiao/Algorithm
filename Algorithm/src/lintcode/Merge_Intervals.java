package lintcode;

import java.util.*;

public class Merge_Intervals {
	public static List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0) {
			return res;
		}

		Cmp cmp = new Cmp();
		Collections.sort(intervals, cmp);
		res.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			if (intervals.get(i).end >= res.get(res.size() - 1).end
					&& intervals.get(i).start <= res.get(res.size() - 1).end) {
				res.get(res.size() - 1).end = intervals.get(i).end;
			} else if (res.get(res.size() - 1).end >= intervals.get(i).end) {
				continue;
			} else {
				res.add(intervals.get(i));
			}
		}
		return res;
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(2, 3));
		intervals.add(new Interval(4, 5));

		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(8, 9));
		intervals.add(new Interval(1, 10));

		List<Interval> res = merge(intervals);
		for (Interval i : res) {
			System.out.println(i.start + ", " + i.end);
		}
	}
}

class Cmp implements Comparator<Interval> {
	@Override
	public int compare(Interval a, Interval b) {
		return a.start - b.start;
	}
}

class Interval {
	int start, end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
