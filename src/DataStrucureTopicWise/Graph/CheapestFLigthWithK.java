package DataStrucureTopicWise.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
 * Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
 * */
public class CheapestFLigthWithK {
	
	 static class Flight {
	        int destination, price;
	        Flight(int destination, int price) {
	            this.destination = destination;
	            this.price = price;
	        }
	    }
	    
	    static class Node {
	        int cost, city, stops;
	        Node(int cost, int city, int stops) {
	            this.cost = cost;
	            this.city = city;
	            this.stops = stops;
	        }
	    }
	    
	    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
	        Map<Integer, List<Flight>> adjMap = new HashMap<>();
	        for (int[] flight : flights) {
	            adjMap.putIfAbsent(flight[0], new ArrayList<>());
	            List<Flight>list=adjMap.get(flight[0]);
	            list.add(new Flight(flight[1], flight[2]));
	            adjMap.put(flight[0], list);
	        }
	        
	        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
	        pq.offer(new Node(0, src, 0));
	        Map<String, Integer> visited = new HashMap<>();
	        
	        while (!pq.isEmpty()) {
	            Node node = pq.poll();
	            int price = node.cost, city = node.city, travelledFlights = node.stops;
	            
	            if (city == dst) return price;
	            if (travelledFlights > K) continue;
	            
	            String key = city + "," + travelledFlights;
	            if (visited.containsKey(key)) continue;
	            
	            visited.put(key, 1);
	            
	            if (adjMap.containsKey(city)) {
	                for (Flight flight : adjMap.get(city)) {
	                    pq.offer(new Node(price + flight.price, flight.destination, travelledFlights + 1));
	                }
	            }
	        }
	        
	        return -1;
	    }
	    
	public static void main(String[] args) {
		int n = 4;
		int flig[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
		int src = 0, dst = 3, k = 2;
		
		CheapestFLigthWithK ob1 = new CheapestFLigthWithK();
		System.out.print(ob1.findCheapestPrice(n, flig, src, dst, k));

	}

}
