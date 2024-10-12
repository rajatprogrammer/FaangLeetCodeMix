package graph;
//https://practice.geeksforgeeks.org/problems/mother-vertex/1/?track=amazon-graphs&batchId=192
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class mother_vertes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	static int findMother(ArrayList<ArrayList<Integer>> list, int E)
    {
		boolean visited[] = new boolean[E+1];
		 Arrays.fill(visited, false);
	     int v=-1;
		for(int i=0;i<E;i++) {
			if(!visited[i]){
                dfsUtil(list, i, visited);
                v=i;
            }
		}
		 Arrays.fill(visited, false);
		  dfsUtil(list, v, visited);
		  for(int i=0; i<E; i++)
        {
            if(!visited[i])
            return -1;
        }
		return v;
    }
	static void dfsUtil(ArrayList<ArrayList<Integer>> list, int v, boolean[] visited){
        visited[v] = true;
        Iterator<Integer> it = list.get(v).listIterator();
        while(it.hasNext()){
            int tmp = it.next();
            if(!visited[tmp]){
                dfsUtil(list,tmp,visited);
            }
        }
    }
}
