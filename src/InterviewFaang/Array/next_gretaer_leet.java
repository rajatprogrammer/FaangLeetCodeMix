package Array;

import java.util.Arrays;

//https://www.geeksforgeeks.org/next-higher-palindromic-number-using-set-digits/
//adobe
public class next_gretaer_leet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="4697557964";
		System.out.println(ans(str));
	}
	public static String ans(String str)
	{
	    char[] ar = new char[str.length()/2];
	    int n =ar.length;
	    for(int j=0;j<ar.length;j++)
	      ar[j]= str.charAt(j);
	     
	       int i;
       
        for (i = ar.length- 1; i > 0; i--) 
        {
            if (ar[i] > ar[i - 1]) {
                break;
            }
        }
    
        if (i == 0) 
        {
            return "-1";
        } 
        else
        {
            int x = ar[i - 1], min = i;
             for (int j = i + 1; j < n; j++) 
            {
                if (ar[j] > x && ar[j] < ar[min]) 
                {
                    min = j;
                }
            }
 
      
            swap(ar, i - 1, min);
 
            Arrays.sort(ar, i, n);
        }
          
	      StringBuilder sb = new StringBuilder();
	      for(int j=0;j<ar.length;j++)
	       sb.append(ar[j]);
	       if (str.length()%2!=0)
	         sb.append(str.charAt(str.length()/2));
	         for(int j=ar.length-1;j>=0;j-- )
	          sb.append(ar[j]);
	      return sb.toString();
	}
	static void swap(char ar[], int i, int j) 
    {
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

}
