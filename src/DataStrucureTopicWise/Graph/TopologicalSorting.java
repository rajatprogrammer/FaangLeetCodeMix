package DataStrucureTopicWise.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//topologcal sorting
public class TopologicalSorting {

	List<Integer>adj[];
	int indegree[];
	public TopologicalSorting(int V) {
		adj = new ArrayList[V];
		indegree = new int[V];
		for(int i=0;i<V;i++) {
			adj[i] = new ArrayList<>();
		}
	}
	
	public void addEdge(int source,int dest) {
		adj[source].add(dest);
	}
	
	public List<Integer> topologicalSOrt(int v) throws Exception {
		
		for (List<Integer> neighbors : adj) {
	            for (int neighbor : neighbors) {
	            	indegree[neighbor]++;
	            }
	        }
		
		Queue<Integer>q = new LinkedList<Integer>();
		
		for(int i=0;i<v;i++) {
			if(indegree[i]==0) {
				q.add(i);
			}
		}
		
		List<Integer> res = new ArrayList<>();
		while(!q.isEmpty()) {
			int data = q.poll();
			 res.add(data);
			for(int val:adj[data]) {
				indegree[val]--;
				if(indegree[val]==0) {
					q.add(val);
				}
			}
		}
		
		if(res.size()!=v) {
			throw new Exception("error");
		}
		
		return res;
	}
	
	
	
	
	public static void main(String[] args) {
		
		 int vertices = 6;
		 
		 TopologicalSorting ob1 = new TopologicalSorting(vertices);
		 ob1.addEdge(5,2);
		 ob1.addEdge(5,0);
		 ob1.addEdge(4,0);
		 ob1.addEdge(4,1);
		 ob1.addEdge(2,3);
		 ob1.addEdge(3,1);
		 
		 try {
			List<Integer> arr=ob1.topologicalSOrt(vertices);
			for(int ar:arr) {
				System.out.print(ar + ",");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
