package CompanyWiseLeetcode.sailsforce;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/elimination-game
 * 
 * 
 * */
public class eliminationGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lastRemaining(9));
	}
	
	 public static int lastRemaining(int n) {
		  if(n==1) return 1;
	        return 2 * (1 + n/2 - lastRemaining(n/2));
	 }
	 
	
}
