package DataStrucureTopicWise.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 *Important  
 * generate all the subsequence
 * */
public class GenerateAllSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> rat = findSubsequences("RAJAT");
		
		for(String x : rat) {
			System.out.println(x);
		}
	}
	
	public static List<String> findSubsequences(String str) {
        List<String> result = new ArrayList<>();
        generateSubsequences(0, str, "", result);
        return result;
    }
	
	
	private static void generateSubsequences(int index, String str, String current, List<String> result) {
        if (index == str.length()) {
            result.add(current); // Base case: add the current subsequence
            return;
        }

        // Include the current character
        generateSubsequences(index + 1, str, current + str.charAt(index), result);

        // Exclude the current character
        generateSubsequences(index + 1, str, current, result);
    }
	
	

}
