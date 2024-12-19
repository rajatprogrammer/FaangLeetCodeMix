package DataStrucureTopicWise.Greedy;

import java.util.Arrays;
//https://leetcode.com/problems/assign-cookies/description/
public class assignCookie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int contentChildren = 0;
        int cookieIndex = 0;
        while (cookieIndex < s.length && contentChildren < g.length) {
            if (s[cookieIndex] >= g[contentChildren]) {
                contentChildren++;
            }
            cookieIndex++;
        }
        return contentChildren;
    }


}
