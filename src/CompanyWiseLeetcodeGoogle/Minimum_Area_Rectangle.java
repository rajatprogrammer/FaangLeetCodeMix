package CompanyWiseLeetcodeGoogle;

import java.util.HashSet;
import java.util.Set;

/*
 * 
 * 
 * https://leetcode.com/problems/minimum-area-rectangle/description
 * 939. Minimum Area Rectangle
Solved
Medium
Topics
Companies
You are given an array of points in the X-Y plane points where points[i] = [xi, yi].

Return the minimum area of a rectangle formed from these points, with sides parallel to the X and Y axes. If there is not any such rectangle, return 0.
 * */
public class Minimum_Area_Rectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minAreaRect(int[][] points) {
        Set<String> pointSet = new HashSet<>();
        for (int[] point : points) {
            pointSet.add(point[0] + "," + point[1]);
        }
        
        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                
                // Check if points (x1, y1) and (x2, y2) can form a rectangle
                if (x1 != x2 && y1 != y2) {
                    if (pointSet.contains(x1 + "," + y2) && pointSet.contains(x2 + "," + y1)) {
                        int area = Math.abs(x2 - x1) * Math.abs(y2 - y1);
                        minArea = Math.min(minArea, area);
                    }
                }
            }
        }
        
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }

}
