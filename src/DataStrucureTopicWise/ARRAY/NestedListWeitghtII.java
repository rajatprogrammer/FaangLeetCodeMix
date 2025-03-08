package DataStrucureTopicWise.ARRAY;

import java.util.List;

/*
 * https://leetcode.com/problems/nested-list-weight-sum-ii/
 * ou are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.

The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth. Let maxDepth be the maximum depth of any integer.

The weight of an integer is maxDepth - (the depth of the integer) + 1.

Return the sum of each integer in nestedList multiplied by its weight.

 

Example 1:


Input: nestedList = [[1,1],2,[1,1]]
Output: 8
Explanation: Four 1's with a weight of 1, one 2 with a weight of 2.
1*1 + 1*1 + 2*2 + 1*1 + 1*1 = 8
Example 2:


Input: nestedList = [1,[4,[6]]]
Output: 17
Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1.
1*3 + 4*2 + 6*1 = 17
 * 
 * 
 * */
public class NestedListWeitghtII {
	
	class Pair {
	    List<NestedInteger> nestedIntegerList;
	    int depth;

	    public Pair(List<NestedInteger> nestedIntegerList, int depth) {
	        this.nestedIntegerList = nestedIntegerList;
	        this.depth = depth;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(nestedList, 1));

        int unweightedSum = 0;
        int weightedSum = 0;
        int currentLevelSum = 0;

        Pair pair = null;
        List<NestedInteger> nestedIntegerList = null;
        int depth = 0;

        int size = 0;

        while(!queue.isEmpty()) {
        	
            size = queue.size();
            currentLevelSum = 0;

            for(int i = 0; i<size; i++) {
                //pull a node
                pair = queue.remove();
                nestedIntegerList = pair.nestedIntegerList;
                depth = pair.depth;

                //explore neighbors
                for(NestedInteger obj: nestedIntegerList) {
                    if(obj.isInteger()) {
                        currentLevelSum += obj.getInteger();
                    } else {
                        queue.add(new Pair(obj.getList(), depth+1));
                    }
                }
            }

            unweightedSum += currentLevelSum;

            weightedSum += unweightedSum;
        }

        return weightedSum;
    }
	

}
