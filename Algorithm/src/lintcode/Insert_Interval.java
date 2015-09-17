package lintcode;

import java.util.ArrayList;

public class Insert_Interval {
	public static ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		ArrayList<Interval> res = new ArrayList<Interval>();

		for (Interval interval : intervals) {
			if (interval.end < newInterval.start) {
				res.add(interval);
			} else if (interval.start > newInterval.end) {
				res.add(newInterval);
				newInterval = interval;
			} else {
				int start = Math.min(interval.start, newInterval.start);
				int end = Math.max(interval.end, newInterval.end);
				newInterval = new Interval(start, end);
			}
		}
		res.add(newInterval);
		return res;
	}

	public static void main(String[] args) {
		Interval i1 = new Interval(1, 5);
		Interval i2 = new Interval(5, 7);
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(i1);
		ArrayList<Interval> res = insert(intervals, i2);
		for (Interval i : res) {
			System.out.println(i.start + ", " + i.end);
		}
	}
}
