package DataStrucureTopicWise.Greedy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/max-points-on-a-line
 * 149. Max Points on a Line
Solved
Hard
Topics
Companies
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
 * 
 * Time complexity: O(n 
2
 ). For each of the n points, we calculate O(n) values of atan2 and insert them into the hash map, which takes O(1). Then, we find the maximum frequency of an angle, which also takes O(n).

Space complexity: O(n). We store O(n) values of atan2 in the hash ma
 * 
 * */
public class max_line {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1) {
            return 1;
        }
        int result = 2;
        for (int i = 0; i < n; i++) {
            Map<Double, Integer> cnt = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    cnt.merge(
                        Math.atan2(
                            points[j][1] - points[i][1],
                            points[j][0] - points[i][0]
                        ),
                        1,
                        Integer::sum
                    );
                }
            }
            result = Math.max(result, Collections.max(cnt.values()) + 1);
        }
        return result;
    }

}
