package DataStrucureTopicWise.Heap;

import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/minimum-processing-time/description/?envType=company&envId=adobe&favoriteSlug=adobe-six-months
public class ProcessingTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minProcessingTime(List<Integer> pro, List<Integer> tasks) {
        Collections.sort(tasks);
        Collections.sort(pro, Collections.reverseOrder());
        int ans=Integer.MIN_VALUE;
        int j=0;
        for(int i=0;i<pro.size();i++){
            for(int k=1;k<=4;k++){
                ans=Math.max(ans,pro.get(i)+tasks.get(j));
                j++;
            }
        }
        return ans;
    }

}
