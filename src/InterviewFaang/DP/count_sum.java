package InterviewFaang.DP;
//https://www.geeksforgeeks.org/count-of-n-digit-numbers-whose-sum-of-digits-equals-to-given-sum/

import java.util.ArrayList;
import java.util.Arrays;




public class count_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		count_sum ob1 =new count_sum();
		System.out.print(Arrays.toString(ob1.recursive(3,6).stream().mapToInt(i->i).toArray()));
		System.out.print(finalCount(3,6));
	}
	public ArrayList<Integer>recursive(int n,int sum){
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int i=1;i<10;i++) {
			calc(i,n-1,sum,res,i);
		}
		return res;
	}
	
	public void calc(int d,int n,int sum,ArrayList<Integer>res,int digTotal){
		if(digTotal>sum) {
			return;
		}
		if(n==0) {
			if(digTotal==sum) {
				res.add(d);
			}
		}else {
			int lastDig = d%10;
			for(int i=1;i<10;i++) {
				lastDig=d*10+i;
				calc(lastDig,n-1,sum,res,digTotal+i);
			}
		}
	}
	static int countRec(int n, int sum) 
    { 
        // Base case 
        if (n == 0) 
        return sum == 0 ?1:0; 
  
            if (sum == 0) 
            return 1; 
      
        // Initialize answer 
        int ans = 0; 
      
        // Traverse through every digit and count 
        // numbers beginning with it using recursion 
        for (int i=0; i<=9; i++) 
        if (sum-i >= 0) 
            ans += countRec(n-1, sum-i); 
      
        return ans; 
    } 
      
    // This is mainly a wrapper over countRec. It 
    // explicitly handles leading digit and calls 
    // countRec() for remaining digits. 
    static int finalCount(int n, int sum) 
    { 
        // Initialize final answer 
        int ans = 0; 
      
        // Traverse through every digit from 1 to 
        // 9 and count numbers beginning with it 
        for (int i = 1; i <= 9; i++) 
        if (sum-i >= 0) 
            ans += countRec(n-1, sum-i); 
      
        return ans; 
    } 

}
