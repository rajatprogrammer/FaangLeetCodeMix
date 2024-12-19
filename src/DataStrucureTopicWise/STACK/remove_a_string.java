package DataStrucureTopicWise.STACK;
//https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/
public class remove_a_string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public String removeOccurrences(String s, String part) {
	        return subs(s,part);
	    }
	    public String subs(String s,String part){
	        int index = s.indexOf(part);
	        if(index == -1){
	            return s;
	        }
	        return subs(s.substring(0,index) + s.substring(index +part.length(),s.length()),part);
	    }

}
