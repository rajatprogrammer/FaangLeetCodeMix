package DataStrucureTopicWise.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/bus-routes/
public class BusRoute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {{1,2,7},{3,6,7}};
		System.out.println(numBusesToDestination(arr,1,6));
		System.out.println(numBusesToDestinationOpyimized(arr,1,6));
	}
	
	public static int numBusesToDestination(int[][] routes, int source, int dest) {
        int N=routes.length;
        Map<Integer,List<Integer>> stopRouteMap=new HashMap<>();
        for (int index=0;index<N;index++){
            for (int stop:routes[index]){
                stopRouteMap.putIfAbsent(stop,new ArrayList<Integer>());
                stopRouteMap.get(stop).add(index);
            }
        }
        if(source==dest){
            return 0;
        }
        if(!stopRouteMap.containsKey(source)|| !stopRouteMap.containsKey(dest)){
            return -1;
        }
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(source);
        int counter=0;
        Set<Integer> visitedStops=new HashSet<>();
        boolean visitedRoutes[]=new boolean[N];
        while(!queue.isEmpty()){
            counter++;
            int stopSize=queue.size();
            for(int ctr=1;ctr<=stopSize;ctr++){
                int stop=queue.poll();
                for(int routeIdx: stopRouteMap.get(stop)){
                    if(visitedRoutes[routeIdx]){
                        continue;
                    }
                    visitedRoutes[routeIdx]=true;
                    for(int rstop:routes[routeIdx]){
                        if(rstop==dest){
                            return counter;
                        }
                        if(!visitedStops.contains(rstop)){
                            queue.add(rstop);
                            visitedStops.add(rstop);
                        }
                    }
                }
            }
        }return -1;
       }
	
	public static int numBusesToDestinationOpyimized(int[][] routes, int source, int target) {
        if (source == target) return 0;

        // Map to associate stops with buses
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();

        // Build stop-to-bus mapping
        for (int bus = 0; bus < routes.length; bus++) {
            for (int stop : routes[bus]) {
                stopToBuses.computeIfAbsent(stop, k -> new ArrayList<>()).add(bus);
            }
        }

        // BFS queues for stops and buses
        Queue<int[]> stopQueue = new LinkedList<>(); // Stores {stop, cost}
        Queue<int[]> busQueue = new LinkedList<>();  // Stores {bus, cost}

        // Visited sets
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedBuses = new HashSet<>();

        // Initialize BFS with the source stop
        stopQueue.offer(new int[]{source, 0});
        visitedStops.add(source);

        while (!stopQueue.isEmpty() || !busQueue.isEmpty()) {
            // Process buses first if available
            if (!busQueue.isEmpty()) {
                int[] currentBus = busQueue.poll();
                int bus = currentBus[0];
                int cost = currentBus[1];

                for (int stop : routes[bus]) {
                    if (!visitedStops.contains(stop)) {
                        stopQueue.offer(new int[]{stop, cost});
                        visitedStops.add(stop);
                    }
                }
            } else {
                // Process stops
                int[] currentStop = stopQueue.poll();
                int stop = currentStop[0];
                int cost = currentStop[1];

                // If the target stop is reached, return the cost
                if (stop == target) return cost;

                for (int bus : stopToBuses.getOrDefault(stop, new ArrayList<>())) {
                    if (!visitedBuses.contains(bus)) {
                        busQueue.offer(new int[]{bus, cost + 1});
                        visitedBuses.add(bus);
                    }
                }
            }
        }

        return -1; // If no path is found
    }
}
