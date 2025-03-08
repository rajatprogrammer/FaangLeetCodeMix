package DataStrucureTopicWise.ModifiedBinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/*
 * https://leetcode.com/discuss/post/2103489/doordash-phone-screen-by-2ub33n-ux4p/
 * Anonymous User
Anonymous User
Last Edit: June 3, 2022 12:33 AM

3.0K VIEWS

"""
A number of cities are arranged on a graph that has been divided up like an ordinary Cartesian plane. Each city is located at an integral (x, y) coordinate intersection. City names and locations are given in the form of three arrays: c, x, and y, which are aligned by the index to provide the city name (c[i]), and its coordinates, (x[i], y[i]). Determine the name of the nearest city that shares either an x or a y coordinate with the queried city. If no other cities share an x or y coordinate, return 'NONE'. If two cities have the same distance to the queried city, q[i], consider the one with an lexographically shorter name (i.e. 'ab' < 'aba' < 'abb') as the closest choice. The distance is the Manhattan distance, the absolute difference in x plus the absolute difference in y.


Example:
Input: n = 3; c = ['c1', 'c2', 'c3']; x = [3, 2, 1] ; y = [3, 2, 3]; q = ['c1', 'c2', 'c3']
Expected Answer: ['c3', 'NONE', 'c1']


Explanation: The three points at (x[i], y[i]) are (3, 3), (2, 2) and (1, 3) represent the coordinates of the cities on the graph. The nearest city to c1 is c3, which shares a y value (distance = (3-1) + (3-3) = 2). City c2 does not have a nearest city as none share an x or y with c2, so this query returns 'NONE'. A query of c3 returns c1 based on the first calculation. The return array after all queries are complete is ['c3', 'NONE', 'c1'].


Function Description


closest_straight_city has the following parameter(s):
    string c[n]: an array of strings that represent the names of each city[i]
    int x[n]: the x coordinates of each city[i]
    int y[n]: the y coordinates of each city[i]
    string q[m]: the names of each city to query
Returns:
    string[m]: an array of m strings where the index of i element denotes the return value of the index of i query
"""
 * */
public class OracleManhattan {
	public static List<String> findNearestPoints(int numOfPoints, String[] points, int[] xCoordinates,
			int[] yCoordinates, int numOfQueriedPoints, String[] queriedPoints) {
		// Mapping points to coordinates
		TreeMap<Integer, TreeMap<Integer, String>> xMap = new TreeMap<>();
		TreeMap<Integer, TreeMap<Integer, String>> yMap = new TreeMap<>();

		Map<String, int[]> pointMap = new HashMap<>();

		for (int i = 0; i < numOfPoints; i++) {
			xMap.putIfAbsent(xCoordinates[i], new TreeMap<>());
			xMap.get(xCoordinates[i]).put(yCoordinates[i], points[i]);

			yMap.putIfAbsent(yCoordinates[i], new TreeMap<>());
			yMap.get(yCoordinates[i]).put(xCoordinates[i], points[i]);

			pointMap.put(points[i], new int[] { xCoordinates[i], yCoordinates[i] });
		}

		List<String> result = new ArrayList<>();

		for (String queriedPoint : queriedPoints) {
			int[] coord = pointMap.get(queriedPoint);
			if (coord == null) {
				result.add("NONE");
				continue;
			}

			int x = coord[0], y = coord[1];
			String nearestPoint = findClosest(xMap.get(x), y);
			String nearestYPoint = findClosest(yMap.get(y), x);

			if (nearestYPoint != null && (nearestPoint == null
					|| getDistance(nearestYPoint, x, y, pointMap) < getDistance(nearestPoint, x, y, pointMap))) {
				nearestPoint = nearestYPoint;
			}

			result.add(nearestPoint != null ? nearestPoint : "NONE");
		}

		return result;
	}

	private static String findClosest(TreeMap<Integer, String> map, int key) {
		if (map == null)
			return null;

		Map.Entry<Integer, String> lower = map.lowerEntry(key);
		Map.Entry<Integer, String> higher = map.higherEntry(key);
		//binary search
		if (lower == null && higher == null)
			return null;
		if (lower == null)
			return higher.getValue();
		if (higher == null)
			return lower.getValue();

		return (Math.abs(lower.getKey() - key) <= Math.abs(higher.getKey() - key)) ? lower.getValue()
				: higher.getValue();
	}

	private static int getDistance(String point, int x, int y, Map<String, int[]> pointMap) {
		int[] coord = pointMap.get(point);
		return Math.abs(coord[0] - x) + Math.abs(coord[1] - y);
	}

	public static void main(String[] args) {
		int numOfPoints = 3;
		String[] points = { "p1", "p2", "p3","p4" };
		int[] xCoordinates = { 30, 20, 10,30 };
		int[] yCoordinates = { 30, 20, 30, 20};
		int numOfQueriedPoints = 3;
		String[] queriedPoints = { "p3", "p2", "p1","p4" };

		List<String> result = findNearestPoints(numOfPoints, points, xCoordinates, yCoordinates, numOfQueriedPoints,
				queriedPoints);
		System.out.println(result); // Output: [p1, NONE, p3]
	}
}
