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
}
