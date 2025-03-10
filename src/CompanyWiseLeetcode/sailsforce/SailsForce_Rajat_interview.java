package CompanyWiseLeetcode.sailsforce;
import java.util.HashSet;

/*
 * 
 * input:-0,8,?,?,8,4,0
 * workHour:-24
 * daly_hour:-20
 * difference:-4
 * return all sequence between range from 0 to 4 . and total sum of the input is 20.
 * */
public class SailsForce_Rajat_interview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "08??840";
		int day_hour = 4;
	    int workHour = 24;
		System.out.print(sequence(input,workHour,day_hour));
	}

	public static HashSet<String> sequence(String input, int workHour, int dayHour) {
		int curSUm = 0;
		int remQue=0;
		for (int i = 0; i < input.length(); i++) {
			if (Character.isDigit(input.charAt(i))) {
				curSUm = curSUm + input.charAt(i) - '0';
			}else {
				remQue++;
			}
		}
		int diff = workHour - curSUm;
		HashSet<String> vp = new HashSet<>();
		return recurs(vp,input,remQue,diff,dayHour,workHour,0);
	}

	public static HashSet<String> recurs(HashSet<String> val, String temp, int remQues, int diff, int dayHour,
			int totalSum, int len) {
		if (remQues == 0) {
			int sum = 0;
			String valFinal = temp.toString();
			for (int i = 0; i < valFinal.length(); i++) {
				sum = sum + valFinal.charAt(i) - '0';
			}
			if (sum == totalSum) {
				val.add(temp.toString());
			}
			return val;
		} else {
			for (int j = len; j < temp.length(); j++) {
				if (temp.charAt(j) == '?') {
					for (int i = 0; i <= dayHour; i++) {
						remQues--;
						temp = temp.substring(0,j) + i + temp.substring(j+1);
						recurs(val,temp,remQues,diff,dayHour,totalSum,len+1);
						remQues++;
						temp = temp.substring(0,j) + '?' + temp.substring(j+1);
					}
				}
			}
		}
		return val;
	}

}
