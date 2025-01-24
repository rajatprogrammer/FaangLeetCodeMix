package CompanyWiseLeetcode.sailsforce;
/*
 * 
 * https://leetcode.com/problems/smallest-substring-with-identical-characters-ii
 * You are given a binary string s of length n and an integer numOps.

You are allowed to perform the following operation on s at most numOps times:

Select any index i (where 0 <= i < n) and flip s[i]. If s[i] == '1', change s[i] to '0' and vice versa.
You need to minimize the length of the longest 
substring
 of s such that all the characters in the substring are identical.

Return the minimum length after the operations.

 

Example 1:

Input: s = "000001", numOps = 1

Output: 2

Explanation: 

By changing s[2] to '1', s becomes "001001". The longest substrings with identical characters are s[0..1] and s[3..4].

Example 2:

Input: s = "0000", numOps = 2

Output: 1

Explanation: 

By changing s[0] and s[2] to '1', s becomes "1010".

Example 3:

Input: s = "0101", numOps = 0

Output: 1

 

Constraints:

1 <= n == s.length <= 105
s consists only of '0' and '1'.
0 <= numOps <= n

 * */
public class SamllestSubstringWithIdentical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int minLength(String ss, int numOps) {
	      int s=1;
	      int e=ss.length();
	      int ans=0;
	      while(s<=e){
	        int m=(s+e)/2;
	        if(test(m,numOps,ss)){
	            ans=m;
	            e=m-1;
	        }
	        else s=m+1;
	      }  
	      return ans;
	    }
	    public boolean test(int m,int n,String s){
	        if(m==1){
	            return check(s,n,'0')||check(s,n,'1');
	        }
	        int c=1;
	        int f=s.charAt(0)-'0';
	        for(int i=1;i<s.length();i++){
	            if(s.charAt(i)==s.charAt(i-1)){
	                c++;
	            }
	            else{
	                n-=(c)/(m+1);
	                c=1;
	            }
	        }
	        n-=(c)/(m+1);
	        return n>=0;

	    }
	    public boolean check(String s,int n,char ch){
	        for(int i=0;i<s.length();i++){
	            if(s.charAt(i)==ch){
	                
	            }
	            else n--;
	            ch=ch=='1'?'0':'1';
	        }
	        return n>=0;
	    }


}
