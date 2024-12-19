/**
 * Find the index of two numbers whose sum equals to target. Array is sorted and may have duplicate values. If there multiple such index, return all of them
Example:
Input: arr : [1,2,2,3,4,4,5]
Output: [[0, 6], [1, 5] ,[1, 4], [2, 5], [2, 4]]
//microsoft
 */
package InterviewFaang.Array;

import java.util.ArrayList;
import java.util.List;

public class equal_target {

	public static void main(String[] args) {
        List<List<Integer>> res = getPairs(new int[]{1,2,2,3,4,4,5}, 6);
        
        for(List<Integer> r:res){
            System.out.println(r.get(0)+", "+r.get(1));
        }

	}
	private static List<List<Integer>> getPairs(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while(start < end){
            if(arr[start] + arr[end] == target){
                List<Integer> temp = new ArrayList<>();
                temp.add(start);
                temp.add(end);
                res.add(temp);
                
                int tempEnd = end-1;
                while(tempEnd > start && arr[tempEnd] + arr[start] == target){
                    temp = new ArrayList<>();
                    temp.add(start);
                    temp.add(tempEnd);
                    res.add(temp);
                    tempEnd--;
                }
                start++;
            }else{
                if(arr[start] + arr[end] < target){
                    start++;
                }else{
                    end--;
                }
            }
        }
        
        return res;
    }

}
