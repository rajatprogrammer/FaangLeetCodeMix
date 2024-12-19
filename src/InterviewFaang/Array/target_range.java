package InterviewFaang.Array;
//https://leetcode.com/problems/reach-a-number/
/**
 * You are standing at position 0 on an infinite number line. There is a goal at position target.

On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.

Return the minimum number of steps required to reach the destination.

Example 1:
Input: target = 3
Output: 2
Explanation:
On the first move we step from 0 to 1.
On the second step we step from 1 to 3.
Example 2:
Input: target = 2
Output: 3
Explanation:
On the first move we step from 0 to 1.
On the second move we step  from 1 to -1.
On the third move we step from -1 to 2.
 * @author rajat
 *
 */
public class target_range {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(reachNumber(5));
			System.out.println(reachNumberRecursive(3));
	}
	
	public static int reachNumber(int target) {
        target = Math.abs(target);
        int k=0;
        int sum=0;
        while(sum<target){
            k++;
            sum=sum+k;
        }
        if((sum-target)%2==0){
          return k;
        }else{
             if(k%2==0){
               return k+1;
           }else{
               return k+2;
           } 
        }
    }
	public static int reachNumberRecursive(int target) {
        return minSteps(Math.abs(target), 0, 0);
    }

    private static int minSteps(int target, int source, int steps) {
        if (Math.abs(source) > target)
            return Integer.MAX_VALUE;
        if (source == target)
            return steps;
        return Math.min(minSteps(target, source + steps + 1, steps + 1), minSteps(target, source - steps - 1, steps + 1));
    }

}
