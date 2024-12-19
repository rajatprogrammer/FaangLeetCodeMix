package DataStrucureTopicWise.recursion;

import java.util.Stack;

//https://www.geeksforgeeks.org/problems/sort-a-stack/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=sort-a-stack
public class sortStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Integer> stack = new Stack<>();
        stack.push(11);
        stack.push(2);
        stack.push(32);
        stack.push(3);
        stack.push(41);

        System.out.println("Original Stack: " + stack);

        // Sort the stack
        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);

	}
	// Function to insert an element in sorted order in a stack
    public static void sortedInsert(Stack<Integer> stack, int element) {
        // If stack is empty or the top element is smaller than or equal to the element
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            // Remove the top element
            int temp = stack.pop();
            // Recursively call sortedInsert to find the correct position
            sortedInsert(stack, element);
            // Push the removed element back
            stack.push(temp);
        }
    }
    
 // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        // If stack is not empty
        if (!stack.isEmpty()) {
            // Remove the top element
            int temp = stack.pop();
            // Sort the remaining stack recursively
            sortStack(stack);
            // Insert the popped element back in the correct position
            sortedInsert(stack, temp);
        }
    }
    
    

}
