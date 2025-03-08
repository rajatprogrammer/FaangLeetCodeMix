package DataStrucureTopicWise.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*https://leetcode.com/problems/reconstruct-itinerary/description/
 * You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.

All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.

For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.

 

Example 1:


Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
Output: ["JFK","MUC","LHR","SFO","SJC"]
Example 2:


Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order
 * 
 * */
public class ReconstructItrenary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> mp = new HashMap<String, PriorityQueue<String>>();
		Iterator<List<String>>itr = tickets.iterator();
		while(itr.hasNext()) {
			List<String> temp = itr.next();
			mp.putIfAbsent(temp.get(0),new PriorityQueue<String>());
			mp.get(temp.get(0)).add(temp.get(1));
		}
		List<String> res = new ArrayList<String>();
		iterateAirport(mp,"JFK",res);
		
		return res;
    }
    public void iterateAirport(Map<String, PriorityQueue<String>>mp,String dest,List<String>res) {
		PriorityQueue<String> pq = mp.get(dest);
		while(pq!=null && !pq.isEmpty()) {
			iterateAirport(mp, pq.poll(), res);
		}
		res.add(0,dest);
	}

}
