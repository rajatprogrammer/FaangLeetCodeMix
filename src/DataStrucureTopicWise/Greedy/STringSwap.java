package DataStrucureTopicWise.Greedy;
//https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/
public class STringSwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minimumSwap(String s1, String s2) {
        int xycount=0;
       int yxcount=0;

       for(int i=0;i<s1.length();i++){
           char c1=s1.charAt(i);
           char c2=s2.charAt(i);

           if(c1=='x' && c2=='y'){
               xycount++;
           }else if(c1=='y' && c2=='x'){
               yxcount++;
           }

       }
       if((xycount +yxcount)%2 !=0){
           return -1;

       }
       return (xycount/2)+(yxcount/2)+(xycount%2)*2;
   }

}
