package DataStrucureTopicWise.DP;

import java.util.ArrayList;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
class Interval { 
    int buy, sell; 
} 
public class buySell2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int maxProfit(int[] price) {
	        int n=price.length;
	        if (n == 1) 
	            return 0;
	  
	        int count = 0; 
	  
	        ArrayList<Interval> sol = new ArrayList<Interval>(); 
	        int i = 0; 
	        while (i < n - 1) { 
	            while ((i < n - 1) && (price[i + 1] <= price[i])) 
	                i++; 
	            if (i == n - 1) 
	                break; 
	  
	            Interval e = new Interval(); 
	            e.buy = i++; 
	            while ((i < n) && (price[i] >= price[i - 1])) 
	                i++; 
	            e.sell = i - 1; 
	            sol.add(e); 
	            count++; 
	        }   
	        if(count==0){
	            return count;    
	        }
	        int total = 0;
	        for(int k=0;k<count;k++){
	           //  System.out.println("" + sol.get(k).sell + "" + sol.get(k).buy);
	             total = total + (price[sol.get(k).sell] - price[sol.get(k).buy]);
	        }
	        return total;
	        
	    }
	
	

}
