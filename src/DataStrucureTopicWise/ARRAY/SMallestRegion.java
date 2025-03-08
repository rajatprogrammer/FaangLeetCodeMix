package DataStrucureTopicWise.ARRAY;
import java.util.*;
/*
 * Given a list of locations, where each location is represented by a list of regions from specific to general (e.g., ["Bengaluru", "Bellandur", "Marathahalli"]), find the smallest area (region) that contains both Area1 and Area2.
Example:
Input:
Locations = [["Bengaluru", "Bellandur", "Marathahalli", "Kormangala"], ["Karnataka", "Bengaluru", "Mysuru"], ["Maharashtra", "Mumbai", "Pune"], ["India", "Karnataka", "Maharashtra"], ["Italy", "Rome", "Venice"], ["World", "India", "Italy"]]
Area1 = "Bengaluru"
Area2 = "Pune"


Output:
Smallest area containing Area1 and Area2: "India"
LCA problem :)
 * 
 * */
public class SMallestRegion {
	
	 public static String findSmallestRegion(List<List<String>> locations, String area1, String area2) {
	        Map<String, String> parentMap = new HashMap<>();
	        
	        // Build a parent map where each region points to its immediate parent
	        for (List<String> regionList : locations) {
	            for (int i = 1; i < regionList.size(); i++) {
	                parentMap.put(regionList.get(i), regionList.get(0));
	            }
	        }
	        
	        // Collect ancestors of area1
	        Set<String> ancestors = new HashSet<>();
	        while (area1 != null) {
	            ancestors.add(area1);
	            area1 = parentMap.get(area1);
	        }
	        
	        // Find the lowest common ancestor with area2
	        while (area2 != null) {
	            if (ancestors.contains(area2)) {
	                return area2;
	            }
	            area2 = parentMap.get(area2);
	        }
	        
	        return null; // If no common region is found (should not happen in a well-formed input)
	    }

	    public static void main(String[] args) {
	        List<List<String>> locations = Arrays.asList(
	            Arrays.asList("Bengaluru", "Bellandur", "Marathahalli", "Kormangala"),
	            Arrays.asList("Karnataka", "Bengaluru", "Mysuru"),
	            Arrays.asList("Maharashtra", "Mumbai", "Pune"),
	            Arrays.asList("India", "Karnataka", "Maharashtra"),
	            Arrays.asList("Italy", "Rome", "Venice"),
	            Arrays.asList("World", "India", "Italy")
	        );
	        
	        String area1 = "Bengaluru";
	        String area2 = "Pune";
	        
	        System.out.println("Smallest Common Region: " + findSmallestRegion(locations, area1, area2));
	    }

}
