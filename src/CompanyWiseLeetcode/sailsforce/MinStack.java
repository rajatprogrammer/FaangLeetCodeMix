package CompanyWiseLeetcode.sailsforce;

import java.util.Stack;

/*
 * https://leetcode.com/problems/min-stack/description/
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.
 * */
public class MinStack {
	 Stack<Integer> s1;
	 Stack<Integer> s2;
	public static void main(String[] args) {}
	    public MinStack() {
	     s1=new Stack<>(); 
	     s2=new Stack<>();  
	    } 
	    public void push(int val) {
	       s1.push(val);
	       if(s2.isEmpty()||val<=s2.peek()){
	        s2.push(val);
	       } 
	    } 
	    public void pop() {
	        int popped = s1.pop(); 
	        if (popped == s2.peek()) {
	            s2.pop();
	        }  
	    }  
	    public int top() {
	        return s1.peek();
	    }  
	    public int getMin() {   
	        return s2.peek();
	    }

}
