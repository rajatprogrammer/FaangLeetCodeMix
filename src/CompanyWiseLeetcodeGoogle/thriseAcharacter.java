package CompanyWiseLeetcodeGoogle;

import java.util.HashMap;

/*
 * https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i
 * 
 * */
public class thriseAcharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s  = "aaaa";
		System.out.println(maximumLength(s));
	}
	
	public static int maximumLength(String s) {
        int max = -1;
        String temp = "";
        temp = temp + s.charAt(0);
        char c = s.charAt(0);
        HashMap<String,Integer> hs  = new HashMap<>();
        for(int i=1;i<s.length();i++) {
        	char t = s.charAt(i);
        	if(c == t) {
        		temp = temp + c;
        		c=t;
        	}else {
        		if(hs.containsKey(temp)) {
        			int val  = hs.get(temp);
        			val = val+1;
        			hs.put(temp, val);
        			if(val<=3) {
        				max = Math.max(val,max);
        			}
        		}else {
        			hs.put(temp, 1);
        		}
        		temp="";
        		c=t;
        	}
        }
        return max;
    }

}
