package DataStrucureTopicWise.recursion;
//https://leetcode.com/discuss/general-discussion/1287402/count-number-of-binary-strings-without-consecutive-1s
public class Consecutive1_without {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 return solve(0,n);
	}
	int solve(int prev,int n)
	{
	   if(n==0) return 0;
	   if(n==1)
	   {
	       if(prev==0)
	       return 2;
	       if(prev==1)
	       return 1;
	   }
	   if(prev==0)
	   return solve(0,n-1)+solve(1,n-1);
	   if(prev==1)
	   return solve(0,n-1);
	}

}
