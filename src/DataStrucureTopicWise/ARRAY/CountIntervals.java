package DataStrucureTopicWise.ARRAY;

import java.util.TreeMap;

/*https://leetcode.com/problems/count-integers-in-intervals/
 * 
 * 
 * 
 * */
public class CountIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	TreeMap<Integer, Integer> m;
    int count = 0;

    public CountIntervals() {
        m = new TreeMap<>();
    }
    
    public void add(int left, int right) {
       if (m.floorKey(right) != null && m.get(m.floorKey(right)) < left) {
        count += right - left + 1;
        m.put(left, right);
    } else {
        int start = left, end = right;
        while (m.floorKey(end) != null && m.get(m.floorKey(end)) >= left) {
            int l = m.floorKey(end);
            int r = m.get(l);
            count -= r - l + 1;
            m.remove(l);

            start = Math.min(start, l);
            end = Math.max(end, r);
        }
        count += end-start+1;
        m.put(start, end);
    }  
    }
    
    public int count() {
        return count;
    }

}
