package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
}
