package CompanyWiseLeetcodeGoogle;

import java.util.HashMap;
import java.util.Map;

/*
 * */
public class STringTOROman {

	static Map<Integer,Character> map;
	
	static int bp [] = {1,5,10,50,100,500,1000};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		map=new HashMap<>();
		map.put(1, 'I');
		map.put(5, 'V');
		map.put(10, 'X');
		map.put(50, 'L');
		map.put(100, 'C');
		map.put(500, 'D');
		map.put(1000, 'M');
		
		int num = 1994;
		System.out.println(intToRoman(num));
		
	}
	
	 public static String intToRoman(int num) {
		 
		 StringBuilder res = new StringBuilder();
		 	while(num>0) {
		 		int idx = binarySearch(num);
		 		int val  = bp[idx];
		 		if(num+1 == val) {
		 			res.append(map.get(bp[idx-1]));
		 		}
		 		res.append(map.get(val));
		 		if(num+1 == val) {
		 			while(bp[idx-1]<=num) {
		 				num = num - bp[idx-1];
		 			}
		 		}else {
		 			num=num-val;
		 		}
		 		
		 	}
		 	return res.toString();
	 }
	 
	 public static int binarySearch(int target) {
		 int i=0;
		 int hi = bp.length-1;
		 int mid=0;
		 while(i<hi) {
			 mid  = i+(hi-i)/2;
			if(bp[mid]<target) {
				i = mid+1;
			}
			else {
				hi = mid;
			}
		 }
		 if(target<bp[i] && bp[i]!=target+1) {
			 return i-1;
		 }else {
			 return i; 
		 }
	 }
	 
	 

}
