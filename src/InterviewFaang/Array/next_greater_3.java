package InterviewFaang.Array;

import java.util.Arrays;

//https://leetcode.com/problems/next-greater-element-iii/
public class next_greater_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=1999999999;
		System.out.print(nextGreaterElement(n));
	}
	
	public static int nextGreaterElement(int n) {
	   String num = ""+n;
	   char[] mov =num.toCharArray();
	   int itr=mov.length-1;
	   int break_point=-1;
	   while(itr>=1) {
		   if(mov[itr]>mov[itr-1]) {
			   break_point=itr-1;
			   break;
		   }
		   itr--;
	   }
	   if(break_point==-1) {
		   return -1;
	   }
	   int minIndex=break_point+1;
	   for(int i=break_point+1;i<num.length();i++) {
		   if(mov[i]>mov[break_point] &&  mov[minIndex]>mov[i] ) {
			   minIndex=i;
		   }
	   }
	   swap(mov,break_point,minIndex);
	   Arrays.sort(mov, break_point+1, mov.length);
	   num =new String(mov);
	   Long lo = Long.parseLong(num);
	   if(Integer.MAX_VALUE<lo) {
		   return -1;
	   }
	   int data = Integer.parseInt(num);
       return data;
    }
	
	static void swap(char ar[], int i, int j)  
    { 
        char temp = ar[i]; 
        ar[i] = ar[j]; 
        ar[j] = temp; 
    } 

}
