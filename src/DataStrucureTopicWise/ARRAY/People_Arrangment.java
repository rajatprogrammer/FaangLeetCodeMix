package DataStrucureTopicWise.ARRAY;

/*Linkdinen
 * https://www.geeksforgeeks.org/seating-arrangement-without-adjacent-p
 * 
 * 
 * 
 * 
 * */
public class People_Arrangment {

	  public static boolean canSeatPeople(int[] seats, int people) {
	        int count = 0;
	        for (int i = 0; i < seats.length; i++) {
	            if (seats[i] == 0) {
	                boolean leftEmpty = (i == 0 || seats[i - 1] == 0);
	                boolean rightEmpty = (i == seats.length - 1 || seats[i + 1] == 0);
	                
	                if (leftEmpty && rightEmpty) {
	                    seats[i] = 1; // Mark as occupied
	                    count++;
	                    
	                    if (count >= people) {
	                        return true;
	                    }
	                }
	            }
	        }
	        return count >= people;
	    }

	    public static void main(String[] args) {
	        int[] seats = {1, 0, 0, 0, 1, 0, 0};
	        int people = 2;
	        System.out.println(canSeatPeople(seats, people)); // Output: true
	    }

}
