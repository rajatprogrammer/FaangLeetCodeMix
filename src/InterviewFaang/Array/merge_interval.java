package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/insert-interval/
public class merge_interval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] insert(int[][] intervals, int[] newInterval) {
		int[][] in = new int[intervals.length + 1][2];
		for (int i = 0; i < intervals.length; i++)
			in[i] = intervals[i];
		in[intervals.length] = newInterval;
		return merge(in);
	}

	public int[][] merge(int[][] intervals) {
		if (intervals.length == 0)
			return intervals;

		List<int[]> list = new ArrayList();
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int[] in = intervals[0];
		int i = 1;
		while (i < intervals.length) {
			if (intervals[i][0] > in[1]) {
				list.add(in);
				in = intervals[i];
			} else {
				in[1] = Math.max(intervals[i][1], in[1]);
			}
			i++;
		}
		list.add(in);

		return list.toArray(new int[list.size()][]);
	}

}
