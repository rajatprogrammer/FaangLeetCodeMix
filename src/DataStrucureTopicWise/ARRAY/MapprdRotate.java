package DataStrucureTopicWise.ARRAY;
//https://leetcode.com/problems/sort-the-jumbled-numbers/description/
//amazon,ggole
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapprdRotate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mapping[] = {0,1,2,3,4,5,6,7,8,9};
		int nums[] = {0,999999999};
		System.out.println(sortJumbled(mapping,nums).toString());
	}
	
	public static int[] sortJumbled(int[] mapping, int[] nums) {
		Map<Integer, List<Integer>> hs = new TreeMap<>();
		int arr[] = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
        	int val = nums[i];
        	StringBuilder sb = new StringBuilder();
        	if(val==0) {
        		sb.insert(0, mapping[0]);	
        	}
        	while(val>0) {
        		int rem = val %10;
        		sb.insert(0, mapping[rem]);
        		val = val/10;
        	}
        	arr[i] = Integer.parseInt(sb.toString());
        	if(hs.containsKey(arr[i])) {
        		List<Integer> mp = hs.get(arr[i]);
        		mp.add(nums[i]);
        	}else {
        		List<Integer> mp = new ArrayList<>();
        		mp.add(nums[i]);
        		hs.put(arr[i],mp);
        	}
        }
        int i=0;
        for(Map.Entry<Integer, List<Integer>> mp : hs.entrySet()) {
        	List<Integer> keyItr = mp.getValue();
        	for(Integer itr : keyItr) {
        		nums[i++] = itr;
        	}
        }
        return nums;
    }

}
