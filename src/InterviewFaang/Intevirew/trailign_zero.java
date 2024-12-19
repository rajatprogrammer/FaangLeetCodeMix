package InterviewFaang.Intevirew;
//https://leetcode.com/problems/factorial-trailing-zeroes/
public class trailign_zero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(trailingZeroes(15));
	}
	public static int trailingZeroes(int n) {
        
        int count =0;
        for(long i=5;n/i>=1;i*=5){
            count+=(n/i);
        }
        return count;
    }

}
