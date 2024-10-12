package LeetcodeChallange;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
//https://leetcode.com/problems/hand-of-straights/description/
public class HandStraights {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int hand [] = {1,2,3,6,2,3,4,7,8};
		int groupSize = 3;
		System.out.println(isNStraightHand(hand,groupSize));
	}
	
	 public static boolean isNStraightHand(int[] hand, int groupSize) {
		        if (hand.length % groupSize != 0) {
		            return false;
		        }
		        Map<Integer, Integer> count = new HashMap<>();
		        for (int card : hand) {
		            count.put(card, count.getOrDefault(card, 0) + 1);
		        }
		        int[] sortedKeys = new int[count.size()];
		        int index = 0;
		        for (int key : count.keySet()) {
		            sortedKeys[index++] = key;
		        }
		        Arrays.sort(sortedKeys);
		        for (int key : sortedKeys) {
		            if (count.get(key) > 0) {
		                int startCount = count.get(key);
		                for (int i = key; i < key + groupSize; i++) {
		                    if (count.getOrDefault(i, 0) < startCount) {
		                        return false;
		                    }
		                    count.put(i, count.get(i) - startCount);
		                }
		            }
		        }
		        return true;
		    }
	 }
//ConcurrentHashMap<Integer, Integer>  hs = new ConcurrentHashMap<>();
//boolean result = true;
//int arr[] = new int[groupSize];
//for (int i : hand) {
//	 if(hs.containsKey(i)) {
//		 hs.put(i, hs.get(i)+1);
//	 }else {
//		 hs.put(i,1);
//	 }
//}
//ArrayList<Integer> sortedKeys = new ArrayList<Integer>(hs.keySet());
//Collections.sort(sortedKeys);
//for(Map.Entry<Integer, Integer>set:hs.entrySet()) {
//	int curKey = set.getKey();
//	int count=0;
//	for(int i=0;i<groupSize;i++) {
//		if(hs.containsKey(curKey)) {
//			int val = hs.get(curKey);
//   		if(val>0) {
//   			count++;
//   			if(val-1 <= 0) {
//   				hs.remove(curKey);
//   			}else {
//   				hs.put(curKey,hs.get(curKey)-1);	
//   			}
//   			curKey=curKey+1;
//   		}else {
//   			hs.remove(curKey);
//   			result=false;
//   			break;
//   		}
//		}else {
//			result=false;
//			break;
//		}
//	}
//	if(count!=groupSize) {
//		result=false;
//		break;
//	}
//	curKey = 0;
//	if(!result) {
//		break;
//	}
//	//System.out.println(set.getKey() +","+ set.getValue());
//}
//return result;
//}

