/**
 * c] A =[..]
B=[..]
two sorted list were given size of B is m and that of A is m+n .
In array A m elements were holes in which you have to keep elements of array B.
and make the array A sorted. Twist was u can't use extra space and you should do it in linear time for i tried my best to figure it out then got to the point
 */
//https://leetcode.com/discuss/compensation/960800/adobe-mts-1-on-campus/783162
package Array;

import java.util.Arrays;

public class sort_2_array {
	//here Integer.Min_Value represent the holes in array
	public static void main(String[] args) {
		int A[] = {Integer.MIN_VALUE,10,Integer.MIN_VALUE,20,25,29,Integer.MIN_VALUE,28,30,Integer.MIN_VALUE};
		int B[] = {5,15,30,40};
		int p1=0;
		int p2=0;
		while(p1<A.length) {
			if(A[p1]==Integer.MIN_VALUE) {
				if(A[p2]!=Integer.MIN_VALUE) {
					p2=p1;	
				}
			}else {
				int temp=A[p2];
				A[p2]=A[p1];
				A[p1]=temp;
				p2++;
			}
			p1++;
		}
		p2=B.length-1;
		p1=A.length-p2-2;
		for(int i = A.length - 1; i >= 0; i--) {
			if (p2 < 0) {
			      break;
			}
			if(p1>=0 && A[p1]>B[p2]) {
				A[i]=A[p1];
				p1--;
			}else {
				A[i] = B[p2];
			      p2--;
			}
		}
		System.out.println(Arrays.toString(A));
	}

}
