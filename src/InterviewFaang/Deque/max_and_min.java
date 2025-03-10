package InterviewFaang.Deque;

import java.util.Stack;

//https://www.geeksforgeeks.org/find-the-maximum-of-minimums-for-every-window-size-in-a-given-array/
public class max_and_min {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10, 20, 30, 50, 10, 70, 30};
		printMaxOfMin(arr.length,arr);
		System.out.println();
		printMaxOfMinBruteForce(arr.length,arr);
	}
	 static void printMaxOfMin(int n,int arr[]) 
	    { 
	        // Used to find previous and next smaller 
	        Stack<Integer> s = new Stack<>(); 
	       
	        // Arrays to store previous and next smaller 
	        int left[] = new int[n+1];   
	        int right[]  = new int[n+1];  
	       
	        // Initialize elements of left[] and right[] 
	        for (int i=0; i<n; i++) 
	        { 
	            left[i] = -1; 
	            right[i] = n; 
	        } 
	       
	        // Fill elements of left[] using logic discussed on 
	        // https://www.geeksforgeeks.org/next-greater-element/ 
	        for (int i=0; i<n; i++) 
	        { 
	            while (!s.empty() && arr[s.peek()] >= arr[i]) 
	                s.pop(); 
	       
	            if (!s.empty()) 
	                left[i] = s.peek(); 
	       
	            s.push(i); 
	        } 
	       
	        // Empty the stack as stack is  
	// going to be used for right[] 
	        while (!s.empty()) 
	            s.pop(); 
	       
	        // Fill elements of right[] using same logic 
	        for (int i = n-1 ; i>=0 ; i-- ) 
	        { 
	            while (!s.empty() && arr[s.peek()] >= arr[i]) 
	                s.pop(); 
	       
	            if(!s.empty()) 
	                right[i] = s.peek(); 
	       
	            s.push(i); 
	        } 
	       
	        // Create and initialize answer array 
	        int ans[] = new int[n+1]; 
	        for (int i=0; i<=n; i++) 
	            ans[i] = 0; 
	       
	        // Fill answer array by comparing minimums of all 
	        // lengths computed using left[] and right[] 
	        for (int i=0; i<n; i++) 
	       { 
	            // length of the interval 
	            int len = right[i] - left[i] - 1; 
	       
	            // arr[i] is a possible answer for this length  
	            // 'len' interval, check if arr[i] is more than 
	            // max for 'len' 
	            ans[len] = Math.max(ans[len], arr[i]); 
	        } 
	       
	        // Some entries in ans[] may not be filled yet. Fill  
	        // them by taking values from right side of ans[] 
	        for (int i=n-1; i>=1; i--) 
	            ans[i] = Math.max(ans[i], ans[i+1]); 
	       
	        // Print the result 
	        for (int i=1; i<=n; i++) 
	            System.out.print(ans[i] + " "); 
	    }
	 
	    static void printMaxOfMinBruteForce(int n,int arr[]) 
	    { 
	        // Consider all windows of different 
	        // sizes starting from size 1 
	        for (int k=1; k<=n; k++) 
	        { 
	            // Initialize max of min for current 
	// window size k 
	            int maxOfMin = Integer.MIN_VALUE; 
	       
	            // Traverse through all windows of  
	// current size k 
	            for (int i = 0; i <= n-k; i++) 
	            { 
	                // Find minimum of current window 
	                int min = arr[i]; 
	                for (int j = 1; j < k; j++) 
	                { 
	                    if (arr[i+j] < min) 
	                        min = arr[i+j]; 
	                } 
	       
	                // Update maxOfMin if required 
	                if (min > maxOfMin) 
	                  maxOfMin = min; 
	            } 
	       
	            // Print max of min for current  
	// window size 
	            System.out.print(maxOfMin + " "); 
	        } 
	    } 
	    

}
