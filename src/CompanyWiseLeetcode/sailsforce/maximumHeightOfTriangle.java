package CompanyWiseLeetcode.sailsforce;

/*
 *
 * You are given two integers red and blue representing the count of red and blue colored balls. You have to arrange these balls to form a triangle such that the 1st row will have 1 ball, the 2nd row will have 2 balls, the 3rd row will have 3 balls, and so on.

All the balls in a particular row should be the same color, and adjacent rows should have different colors.

Return the maximum height of the triangle that can be achieved.

 

Example 1:

Input: red = 2, blue = 4

Output: 3

Explanation:

 * 
 * */
public class maximumHeightOfTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}	
	public int helper(int ball1,int ball2){
        int rowsCount1 = (int)Math.sqrt(ball1);
        int rowsCount2=0;

        if(ball2<=1){
            rowsCount2 = 0;
        }else{
            rowsCount2 =  (-1 + (int)Math.sqrt(1+4*ball2))/2;
        }
        if(rowsCount2 >=rowsCount1){
            return 2*rowsCount1;
        }
        return 2*rowsCount2 +1;
    }
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(helper(red,blue),helper(blue,red));
    }

}
