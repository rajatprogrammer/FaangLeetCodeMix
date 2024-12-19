package InterviewFaang.Recusrsion;
import java.util.ArrayList;
//https://leetcode.com/problems/word-break/
import java.util.HashSet;
import java.util.List;

public class Word_break {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Word_break ob1 = new Word_break();
		String s = "leetcode";
		List<String> ls = new ArrayList<String>();
		ls.add("leet");
		ls.add("code");
		System.out.print(ob1.wordBreak(s, ls));
	}
	 public boolean wordBreak(String s, List<String> wordDict) {
		 if(s.length()==0)return true;
		 HashSet<String> dict = new HashSet<>();
		 for (String str : wordDict){
	            dict.add(str);
	      }
		 boolean dp[] = new boolean[s.length()+1];
		 dp[0]=true;
		 for(int i=1;i<=s.length();i++) {
			 for(int j=i-1;j>=0;j--) {
				 if(dp[j] && dict.contains(s.substring(j,i))){
					 	dp[i]=true;
					 	break;
				 }
			 }
		 }
		 return dp[s.length()];
	 }
}
