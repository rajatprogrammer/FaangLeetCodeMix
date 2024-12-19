package InterviewFaang.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://www.geeksforgeeks.org/find-four-elements-that-sum-to-a-given-value-set-2/
//https://leetcode.com/problems/4sum/
public class Four_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Four_Sum ob1 = new Four_Sum();
		int arr[] = { 1, 0, -1, 0, -2, 2 };
		List<List<Integer>> res = ob1.fourSum(arr, 0);
		System.out.print(res.toString());
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ls = new ArrayList<List<Integer>>();
		HashMap<Integer, ArrayList<Integer>> hs = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int sum = nums[i] + nums[j];
				ArrayList<Integer> ls1 = new ArrayList<Integer>();
				ls1.add(i);
				ls1.add(j);
				hs.put(sum, ls1);
			}
		}

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int sum = nums[i] + nums[j];
				if (hs.containsKey(target - sum)) {
					ArrayList<Integer> check = hs.get(target - sum);
					if (check.contains(i) || check.contains(j)) {
						continue;
					} else {
						boolean tr=false;
						for (List<Integer> r : ls) {
							if (r.contains(nums[i]) && r.contains(nums[j]) && r.contains(nums[check.get(0)])
									&& r.contains(nums[check.get(1)])) {
								tr=true;
								break;
							}
						}
						if(tr) {
							continue;
						}
							ArrayList<Integer> res = new ArrayList<Integer>();
							check.forEach(e -> {
								res.add(nums[e]);
							});
							res.add(nums[i]);
							res.add(nums[j]);
							ls.add(res);
					}
				}
			}
		}
		return ls;

	}
	
	  public List<List<Integer>>fourSumOptimized(int[] nums, int target) {
	       List<List<Integer>> result = new ArrayList<>();
	       Set<List<Integer>> resultSet = new HashSet<>(); 
	        
	        Arrays.sort(nums); 
	        
	        for (int i = 0; i < nums.length - 3; i++) {
	            for (int j = i + 1; j < nums.length - 2; j++) {
	                int left = j + 1;
	                int right = nums.length - 1;
	                
	                while (left < right) {
	                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
	                    if (sum == target) {
	                        List<Integer> arr = new ArrayList<>();
	                        arr.add(nums[i]);
	                        arr.add(nums[j]);
	                        arr.add(nums[left]);
	                        arr.add(nums[right]);
	                        
	                        if (!resultSet.contains(arr)) {
	                            resultSet.add(arr); 
	                        }
	                        
	                        left++;
	                        right--;
	                    } else if (sum <= target) {
	                        left++;
	                    } else if(sum > target){
	                        right--;
	                    }
	                }
	            }
	        }
	        
	        result.addAll(resultSet); 
	        
	        return result;
	    }
}
