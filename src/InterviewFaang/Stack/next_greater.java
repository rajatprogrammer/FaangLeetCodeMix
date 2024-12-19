package InterviewFaang.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//https://www.geeksforgeeks.org/next-greater-element/
//https://www.interviewbit.com/problems/nextgreater/
//amazon
public class next_greater {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			long ar[] = new long[n];
			for (int i = 0; i < n; i++) {
				ar[i] = sc.nextLong();
			}

			Stack<Long> stack = new Stack<>();

			for (int i = n - 1; i >= 0; i--) {
				if (stack.isEmpty()) {
					stack.add(ar[i]);
					ar[i] = -1;
				} else {
					if (stack.peek() > ar[i]) {
						long val = stack.peek();
						stack.push(ar[i]);
						ar[i] = val;
					} else {
						while (!stack.isEmpty() && ar[i] >= stack.peek()) {
							stack.pop();
						}
						if (stack.isEmpty()) {
							stack.push(ar[i]);
							ar[i] = -1;
						} else {
							long val = ar[i];
							ar[i] = stack.peek();
							stack.push(val);
						}
					}
				}
			}

			for (int i = 0; i < n; i++) {
				System.out.print(ar[i] + " ");
			}
			System.out.println();
		}

	}
	public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
	       Stack<Integer> as = new Stack<Integer>();
		        ArrayList<Integer> res = new ArrayList<Integer>();
		        Stack<Integer>stk = new Stack<Integer>();
		        for(int i=A.size()-1;i>=0;i--){
		            while(stk.size()>0 && stk.peek()<A.get(i)){
		                stk.pop();
		            }
		            
		            if(stk.size()==0) {
		            	as.add(-1);
		            }else {
		            	as.add(stk.peek());
		            }
		            stk.add(A.get(i));
		        }
		        while(as.size()>0) {
		    	   res.add(as.pop());
		       }
		        return res;
		    }

}
