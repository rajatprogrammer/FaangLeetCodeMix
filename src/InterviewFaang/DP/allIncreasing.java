package InterviewFaang.DP;
//https://www.geeksforgeeks.org/count-all-increasing-subsequences/
public class allIncreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static int countSub(int arr[], int n) 
    { 
        // count[] array is used to store all 
        // sub-sequences possible using that  
        // digit count[] array covers all  
        // the digit from 0 to 9 
        int count[] = new int[10];   
  
        // scan each digit in arr[]  
        for (int i = 0; i < n; i++) 
        { 
            // count all possible sub- 
            // sequences by the digits 
            // less than arr[i] digit 
            for (int j = arr[i] - 1; j >= 0; j--) 
                count[arr[i]] += count[j];   
                  
            // store sum of all sub-sequences  
            // plus 1 in count[] array 
            count[arr[i]]++; 
        }    
  
        // now sum up the all sequences 
        // possible in count[] array 
        int result = 0; 
        for (int i = 0; i < 10; i++) 
            result += count[i]; 
  
        return result; 
    } 

}
