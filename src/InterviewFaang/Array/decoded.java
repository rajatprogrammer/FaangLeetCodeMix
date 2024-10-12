package Array;

import java.util.HashMap;

//https://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
public class decoded {
	static HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(countDecodingDP("2021".toCharArray(),3));
		System.out.println(countDecodingRecursive("2021".toCharArray(),0));
		System.out.println(countDecodingDPOptimized("2021".toCharArray(),0));
	}

	static int countDecodingRecursive(char digits[], int i) {
		if(digits.length<=i) {
			return 1;
		}
		if(digits[i]=='0') {
			return 0;
		}
		int ways = countDecodingRecursive(digits,i+1);
		if(i+1 < digits.length && Integer.parseInt(""+digits[i]+digits[i+1])<=26) {
			ways =ways+countDecodingRecursive(digits,i+2);
		}
		return ways;
		
	}
	static int countDecodingDPOptimized(char digits[], int i) {
		if(digits.length<=i) {
			return 1;
		}
		if(digits[i]=='0') {
			return 0;
		}
		if(hs.containsKey(i)) {
			return hs.get(i);
		}
		int ways = countDecodingRecursive(digits,i+1);
		if(i+1 < digits.length && Integer.parseInt(""+digits[i]+digits[i+1])<=26) {
			ways =ways+countDecodingRecursive(digits,i+2);
		}
		hs.put(i, ways);
		return ways;
	}

//	static int countDecodingDP(char digits[], int n) {
//		// A table to store results of subproblems 
//		int count[] = new int[n + 1];
//		count[0] = 1;
//		count[1] = 1;
//		if (digits[0] == '0') // for base condition "01123" should return 0
//			return 0;
//		for (int i = 2; i <= n; i++) {
//			count[i] = 0;
//
//		// If the last digit is not 0,  
//		// then last digit must add to 
//		// the number of words 
//			if (digits[i - 1] > '0')
//				count[i] = count[i - 1];
//
//		// If second last digit is smaller 
//		// than 2 and last digit is smaller 
//		// than 7, then last two digits  
//		// form a valid character 
//			if (digits[i - 2] == '1' || (digits[i - 2] == '2' && digits[i - 1] < '7'))
//				count[i] += count[i - 2];
//		}
//		return count[n];
//	}

}
