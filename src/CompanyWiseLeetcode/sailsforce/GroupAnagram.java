package CompanyWiseLeetcode.sailsforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/group-anagrams/description/
 * Given an array of strings strs, group the 
anagrams
 together. You can return the answer in any order.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]

 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
 * */
public class GroupAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String,List<String>> hs = new HashMap<>();
        for(int i=0;i<strs.length;i++){
           char seq[] = strs[i].toCharArray();
			Arrays.sort(seq);
			String sortedString = new String(seq);
            if(hs.containsKey(sortedString)){
                List<String>ls = hs.get(sortedString);
                ls.add(strs[i]);
            }else{
                List<String> ls = new ArrayList<>();
                ls.add(strs[i]);
                hs.put(sortedString,ls);  
            }
        }
        for(Map.Entry<String,List<String>> entry :hs.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

}
