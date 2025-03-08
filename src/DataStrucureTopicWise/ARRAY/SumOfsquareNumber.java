package DataStrucureTopicWise.ARRAY;

/*
 * https://leetcode.com/problems/sum-of-square-numbers/description
 * 633. Sum of Square Numbers
Solved
Medium
Topics
Companies
Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

 

Example 1:

Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:

Input: c = 3
Output: false
 * 
 * 
 * 
 * */
public class SumOfsquareNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean judgeSquareSum(int c) {
        long left = 0, right = (long) Math.sqrt(c);
        while (left <= right) {
            if (left * left + right * right == c) return true;
            else if (left * left + right * right > c) right--;
            else left++;
        }
        return false;
    }

}
