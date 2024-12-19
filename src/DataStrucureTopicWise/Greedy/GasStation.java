package DataStrucureTopicWise.Greedy;
//https://leetcode.com/problems/gas-station/description/
public class GasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int gas[] = {1,2,3,4,5}, cost[] = {3,4,5,1,2};
		System.out.println(canCompleteCircuit(gas,cost));
	}
	
	public static int canCompleteCircuit(int[] gas, int[] cost) {
        int currGain = 0, totalGain = 0, answer = 0;

        for (int i = 0; i < gas.length; ++i) {
            // gain[i] = gas[i] - cost[i]
            totalGain += gas[i] - cost[i];
            currGain += gas[i] - cost[i];

            // If we meet a "valley", start over from the next station
            // with 0 initial gas.
            if (currGain < 0) {
                answer = i + 1;
                currGain = 0;
            }
        }

        return totalGain >= 0 ? answer : -1;
    }

}
