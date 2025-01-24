package CompanyWiseLeetcode.sailsforce;

/*
 *https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i/
 *ou are given a 2D binary array grid. Find a rectangle with horizontal and vertical sides with the smallest area, such that all the 1's in grid lie inside this rectangle.

Return the minimum possible area of the rectangle.

 

Example 1:

Input: grid = [[0,1,0],[1,0,1]]

Output: 6

Explanation:
 * 
 * */
public class minimumAreAtoCOverAll1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int minimumArea(int[][] grid) {
        int minr=Integer.MAX_VALUE,maxr=0,minc=Integer.MAX_VALUE,maxc=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    minr=Math.min(minr,i);
                    maxr=Math.max(maxr,i);
                    minc=Math.min(minc,j);
                    maxc=Math.max(maxc,j);
                }
            }
        }
        int len=maxr-minr+1;
        int wid=maxc-minc+1;
        return len*wid; 
    }

}
