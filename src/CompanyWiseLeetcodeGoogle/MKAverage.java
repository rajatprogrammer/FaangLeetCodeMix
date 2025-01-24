package CompanyWiseLeetcodeGoogle;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/*
 * You are given two integers, m and k, and a stream of integers. You are tasked to implement a data structure that calculates the MKAverage for the stream.

The MKAverage can be calculated using these steps:

If the number of the elements in the stream is less than m you should consider the MKAverage to be -1. Otherwise, copy the last m elements of the stream to a separate container.
Remove the smallest k elements and the largest k elements from the container.
Calculate the average value for the rest of the elements rounded down to the nearest integer.
Implement the MKAverage class:

MKAverage(int m, int k) Initializes the MKAverage object with an empty stream and the two integers m and k.
void addElement(int num) Inserts a new element num into the stream.
int calculateMKAverage() Calculates and returns the MKAverage for the current stream rounded down to the nearest integer.
 

Example 1:

Input
["MKAverage", "addElement", "addElement", "calculateMKAverage", "addElement", "calculateMKAverage", "addElement", "addElement", "addElement", "calculateMKAverage"]
[[3, 1], [3], [1], [], [10], [], [5], [5], [5], []]
Output
[null, null, null, -1, null, 3, null, null, null, 5]

Explanation
MKAverage obj = new MKAverage(3, 1); 
obj.addElement(3);        // current elements are [3]
obj.addElement(1);        // current elements are [3,1]
obj.calculateMKAverage(); // return -1, because m = 3 and only 2 elements exist.
obj.addElement(10);       // current elements are [3,1,10]
obj.calculateMKAverage(); // The last 3 elements are [3,1,10].
                          // After removing smallest and largest 1 element the container will be [3].
                          // The average of [3] equals 3/1 = 3, return 3
obj.addElement(5);        // current elements are [3,1,10,5]
obj.addElement(5);        // current elements are [3,1,10,5,5]
obj.addElement(5);        // current elements are [3,1,10,5,5,5]
obj.calculateMKAverage(); // The last 3 elements are [5,5,5].
                          // After removing smallest and largest 1 element the container will be [5].
                          // The average of [5] equals 5/1 = 5, return 5
 * */
public class MKAverage {
	
	private TreeMap<Integer, Integer> counts;
    private Deque<Integer> stream;
    private int m;
    private int k;
    private int totalSum = 0;
    private int totalSize = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public MKAverage(int m, int k) {
        counts = new TreeMap<>();
        stream = new LinkedList<>();
        this.m = m;
        this.k = k;
    }
    
    public void addElement(int num) {
        totalSum += num;
        totalSize++;
        stream.add(num);
        if (stream.size() > m) {
            Integer key = stream.removeFirst();
            counts.put(key, counts.get(key) - 1);
            totalSum -= key;
            if (counts.get(key) == 0) counts.remove(key);
        }
        counts.put(num, counts.getOrDefault(num, 0) + 1);
    }
    
    public int calculateMKAverage() {
        if (totalSize < m) return -1;
        
        int key = counts.firstKey();
        int lastKey = counts.lastKey();
        int kSmall = k, kLarge = k;

        int extremeSum = 0;

        System.out.println(counts.toString());
        
        while (kSmall > 0) {
            int toSubtractSmall = Math.min(kSmall, counts.get(key));
            kSmall -= toSubtractSmall;
            extremeSum += key * toSubtractSmall;
            System.out.println(key + toSubtractSmall);
            if (toSubtractSmall == counts.get(key)) key = counts.higherKey(key);
        }

        while (kLarge > 0) {
            int toSubtractLarge = Math.min(kLarge, counts.get(lastKey));
            kLarge -= toSubtractLarge;
            extremeSum += lastKey * toSubtractLarge;
            System.out.println(lastKey + toSubtractLarge);
            if (toSubtractLarge == counts.get(lastKey)) lastKey = counts.lowerKey(lastKey);
        }
        
        int ret = (totalSum - extremeSum) / (m - 2 * k);
        
        return ret;
    }
	
	

}
