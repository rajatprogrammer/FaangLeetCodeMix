package DataStrucureTopicWise.recursion;
/*
 * https://leetcode.com/problems/additive-number/description/
 * An additive number is a string whose digits can form an additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

Given a string containing only digits, return true if it is an additive number or false otherwise.

Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

 

Example 1:

Input: "112358"
Output: true
Explanation: 
The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
Example 2:

Input: "199100199"
Output: true
Explanation: 
The additive sequence is: 1, 99, 100, 199. 
1 + 99 = 100, 99 + 100 = 199
 

Constraints:

1 <= num.length <= 35
num consists only of digits.
 * 
 * 
 * 
 * */
public class AdditiveNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isAdditiveNumber(String num) {
        return sol(num,0,-1,-1,0);
    }
    public boolean sol(String s,int idx,int p1,int p2,int c){
        if(idx==s.length()) return c>=3;
        int n=0;
        for(int i=idx;i<s.length();i++){
            n=n*10+s.charAt(i)-'0';
            if(p1==-1 || p2==-1 || p1+p2==n){
                if(sol(s,i+1,p2,n,c+1)) return true;
            }
            if(s.charAt(idx)-'0'==0) break;
        }
        return false;
    }

}
