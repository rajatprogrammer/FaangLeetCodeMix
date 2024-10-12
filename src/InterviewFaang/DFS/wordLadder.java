package DFS;
//https://leetcode.com/problems/word-ladder/
//amazon
/*127. Word Ladder
Hard

4362

1371

Add to List

Share
Given two words beginWord and endWord, and a dictionary wordList, return the length of the shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Return 0 if there is no such transformation sequence.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 

Constraints:

1 <= beginWord.length <= 100
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the strings in wordList are unique
 * */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class wordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
		List<String> ls = new ArrayList<String>();
		ls.add("hot");
		ls.add("dot");
		ls.add("dog");
		ls.add("lot");
		ls.add("log");
		ls.add("cog");
		String end = "cog";
		//System.out.println(ladderLength(begin, end, ls));
		System.out.println(ladderLengthOptimized(begin, end, ls));
	}
	public static int ladderLengthOptimized(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet(wordList); // for quick lookup convert list to set
        
        Queue<String> queue = new LinkedList();
        Set<String> visited = new HashSet();
        
        queue.add(beginWord); // add beginWord in queue
        visited.add(beginWord); // mark visited beginWord
        
        int level = 0; // initialize level 
        
        while(!queue.isEmpty()) {
            int size = queue.size(); // for level by level
            level++;
            while(size-- > 0) {
                String word = queue.poll();
                if(endWord.equals(word)) // if current word is endWord return level
                    return level;
                for(int i = 0; i < word.length(); i++) { // for each characters of word
                    for(char c = 'a'; c <= 'z'; c++) { // replace with a-z 
                        String newWord = word.substring(0, i) + c + word.substring(i + 1);
                        if(wordSet.contains(newWord) && !visited.contains(newWord)) { // check if newWrod is in wordSet and not visited
                            queue.add(newWord); // add in queue
                            visited.add(newWord); // mark visited
                        }
                    }
                }
            }
        }
        
        return 0;
    }
//designed by me give tle
//	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
//		HashSet<String> trav = new HashSet<String>();
//		HashSet<String> set = new HashSet<String>();
//		Queue<String> q = new LinkedList<String>();
//		int level = 0;
//		trav.add(beginWord);
//		q.add(beginWord);
//		while (!q.isEmpty()) {
//			int size = q.size();
//			level++;
//			while (size-- > 0) {
//				String word = q.poll();
//				if (word.equals(endWord)) {
//					return level;
//				}
//				for (int i = 0; i < word.length(); i++) {
//					String hashWord = word.substring(0, i) + '$' + word.substring(i + 1);
//					set.add(hashWord);
//				}
//				for (String wList : wordList) {
//					if (!(trav.contains(wList))) {
//						for (int i = 0; i < wList.length(); i++) {
//							String hashWord = wList.substring(0, i) + '$' + wList.substring(i + 1);
//							if (set.contains(hashWord)) {
//								q.add(wList);
//								trav.add(wList);
//							}
//						}
//					}
//				}
//
//			}
//		}
//		return 0;
//	}
	//optimized solution
	
}
