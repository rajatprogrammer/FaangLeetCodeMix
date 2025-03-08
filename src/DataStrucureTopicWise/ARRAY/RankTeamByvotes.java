package DataStrucureTopicWise.ARRAY;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/rank-teams-by-votes/description/
 * In a special ranking system, each voter gives a rank from highest to lowest to all teams participating in the competition.

The ordering of teams is decided by who received the most position-one votes. If two or more teams tie in the first position, we consider the second position to resolve the conflict, if they tie again, we continue this process until the ties are resolved. If two or more teams are still tied after considering all positions, we rank them alphabetically based on their team letter.

You are given an array of strings votes which is the votes of all voters in the ranking systems. Sort all teams according to the ranking system described above.

Return a string of all teams sorted by the ranking system.

 

Example 1:

Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
Output: "ACB"
Explanation: 
Team A was ranked first place by 5 voters. No other team was voted as first place, so team A is the first team.
Team B was ranked second by 2 voters and ranked third by 3 voters.
Team C was ranked second by 3 voters and ranked third by 2 voters.
As most of the voters ranked C second, team C is the second team, and team B is the third.
Example 2:

Input: votes = ["WXYZ","XYZW"]
Output: "XWYZ"
Explanation:
X is the winner due to the tie-breaking rule. X has the same votes as W for the first position, but X has one vote in the second position, while W does not have any votes in the second position. 
Example 3:

Input: votes = ["ZMNAGUEDSJYLBOPHRQICWFXTVK"]
Output: "ZMNAGUEDSJYLBOPHRQICWFXTVK"
Explanation: Only one voter, so their votes are used for the ranking.
 
 * 
 * */
public class RankTeamByvotes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public String rankTeams(String[] votes) {
	        // store the num of total teams
	        int n = votes[0].length();

	        // a 2D array to store the frequencies
	        int count[][] = new int[26][n]; 

	        //store the freq
	        for(String vote : votes){
	            for(int i = 0; i < n; i++){
	                count[vote.charAt(i) - 'A'][i]++;
	            }
	        }

	        // make a dummy array for the teams to be in sorted order
	        Character dummy[] = new Character[n];
	        
	        //store values in the dummy
	        for(int i = 0; i < n; i++){
	            dummy[i] = votes[0].charAt(i);
	        }
	        
	        
	        //sort the array on the basis of: 1. their occurence in first , second or third pos
	        // 2. which comes first

	        Arrays.sort(dummy, (a,b)->{
	            int indexA = a - 'A', indexB = b - 'A';
	            for(int i = 0; i < n; i++){
	                int difference = count[indexA][i] - count[indexB][i];
	                if(difference != 0) // frequencies are not same
	                    return difference > 0 ? -1 : 1;
	            }
	            return a - b;
	        });

	        // StringBuilder to convert to string as char[] cannot be directly converted to string

	        StringBuilder result = new StringBuilder();
	        for(char ch : dummy){
	            result.append(ch);
	        }

	        return result.toString();
	    }

}
