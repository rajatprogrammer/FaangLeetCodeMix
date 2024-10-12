package DFS;
//https://www.geeksforgeeks.org/stepping-numbers/
public class amazonStepping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 0, m = 21; 
		  
        // Display Stepping Numbers in the range [n,m] 
        displaySteppingNumbers(n,m);
	}
	 public static boolean isStepNum(int n) 
	    { 
	        int prevDigit = -1; 
	  
	        // Iterate through all digits of n and compare 
	        // difference between value of previous and 
	        // current digits 
	        while (n > 0) 
	        { 
	            // Get Current digit 
	            int curDigit = n % 10; 
	  
	            // Single digit is consider as a 
	            // Stepping Number 
	            if (prevDigit != -1) 
	            { 
	                // Check if absolute difference between 
	                // prev digit and current digit is 1 
	                if (Math.abs(curDigit-prevDigit) != 1) 
	                    return false; 
	            } 
	            n /= 10; 
	            prevDigit = curDigit; 
	        } 
	        return true; 
	    }
	 // A brute force approach based function to find all 
	    // stepping numbers. 
	    public static void displaySteppingNumbers(int n,int m) 
	    { 
	        // Iterate through all the numbers from [N,M] 
	        // and check if it is a stepping number. 
	        for (int i = n; i <= m; i++) 
	            if (isStepNum(i)) 
	                System.out.print(i+ " "); 
	    } 
	  

}
