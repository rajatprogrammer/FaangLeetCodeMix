package BitSManipulation;
//https://www.geeksforgeeks.org/count-set-bits-in-an-integer/
public class setBit {

	public static void main(String[] args) {
		System.out.print(countSetBits(200));
	}
	static int countSetBits(int n) 
	{ 
		int count = 0; 
		while (n > 0) {
			System.out.println(n);
			n &= (n - 1); 
			count++; 
		} 
		return count; 
	} 


}
