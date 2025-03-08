package DataStrucureTopicWise.ARRAY;
/*
 * https://leetcode.com/problems/shortest-word-distance-iii
 * Given an array of strings wordsDict and two strings that already exist in the array word1 and word2, return the shortest distance between the occurrence of these two words in the list.

Note that word1 and word2 may be the same. It is guaranteed that they represent two individual words in the list.

 

Example 1:

Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
Output: 1
Example 2:

Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "makes"
Output: 3
 
 * 
 * 
 * 
 * 
 * */
public class SHortestWordDistance {

	public static void main(String[] args) {

	}
	
	public static int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        // Initialize it to maximum integer as it will store the minimum distance.
        int shortestDistance = Integer.MAX_VALUE;

        // Initialize it to -1 as it's not pointing to any index yet.
        int prevIndex = -1;
        for (int i = 0; i < wordsDict.length; i++) {
            // If the string at this index is either word1 or word2
            if (wordsDict[i].equals(word1) || wordsDict[i].equals(word2)) {
                // If prevIndex is present and pointing to a different string than the string at the current index
                // Or if both word1 and word2 are the same.
                if (prevIndex != -1 && (!wordsDict[prevIndex].equals(wordsDict[i]) || word1.equals(word2))) {
                    shortestDistance = Math.min(shortestDistance, i - prevIndex);
                }
                // Update the prevIndex to point it to the current index.
                prevIndex = i;
            }
        }
        return shortestDistance;
    }

}
