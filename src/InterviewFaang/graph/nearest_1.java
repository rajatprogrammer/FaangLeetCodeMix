package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/distance-nearest-cell-1-binary-matrix/
//amazon
public class nearest_1 {
	static class pair{
		int i,j;
		public pair(int i,int j) {
			this.i=i;
			this.j=j;
		}
	}
	static class Pair {
	    int first, second;
	    Pair(int x, int y) {
	        this.first = x;
	        this.second = y;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = {{
			0, 0, 0, 1,
            0, 0, 1, 1,
            0, 1, 1, 0}};
		ArrayList<ArrayList<Integer>> inp = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<mat.length;i++) {
			ArrayList<Integer>j1 = new ArrayList<Integer>();
			for(int j=0;j<mat[0].length;j++) {
				j1.add(j,mat[i][j]);
			}
			inp.add(i,j1);
		}
		inp=nearestOrignal(inp,mat.length,mat[0].length);
		for(ArrayList<Integer> itr:inp) {
			Integer ar[] = new Integer[itr.size()];
			itr.toArray(ar);
			System.out.println(Arrays.toString(ar));
		}
	}
	// made by Rajat
	static ArrayList<ArrayList<Integer>> nearest(ArrayList<ArrayList<Integer>> mat, int R, int C ) {
		Queue<pair> one = new LinkedList<pair>();
		ArrayList<ArrayList<Integer>> output = new ArrayList<>();
		int dist[][] = new int[R][C];
		for(int i=0;i<mat.size();i++) {
			for(int j=0;j<mat.get(0).size();j++) {
				if(mat.get(i).get(j)==0) {
					dist[i][j] = Integer.MAX_VALUE;
				}else {
					dist[i][j]=0;
					one.add(new pair(i, j));
				}
			}
		}
		while(!one.isEmpty()) {
			int directionX[] = {1,0,-1,0}; 
			int directionY[] = {0,1,0,-1};
			pair p=one.poll();
			int idx = p.i;
			int idy=p.j;
			for(int mov=0;mov<4;mov++) {
				int movX=idx+directionX[mov];
				int movY=idy+directionY[mov];
				if(movX>=0 && movY>=0 && movX<R && movY<C && dist[movX][movY] > dist[idx][idy] + 1) {
					dist[movX][movY] = dist[idx][idy] + 1;
					  one.add(new pair(movX, movY));
				}
			}
		}
		for(int i=0;i<mat.size();i++) {
			ArrayList<Integer> p1=new ArrayList<Integer>();
			for(int j=0;j<mat.get(0).size();j++) {
				p1.add(j,dist[i][j]);
			}
			output.add(i,p1);
		}
		
		return output;
    }
	
	 static ArrayList<ArrayList<Integer>> nearestOrignal(ArrayList<ArrayList<Integer>> list, int row, int col) {
	        int newx[] = {-1, 0, 1, 0};
	        int newy[] = {0, -1, 0, 1};

	        int dist[][] = new int[row][col];

	        // queue of pairs to store nodes for bfs
	        Queue<Pair> q = new LinkedList<>();

	        // traverse matrix and make pair of indices of
	        // cell (i,j) having value '1' and push them
	        // in queue
	        for (int i = 0; i < row; i++) {
	            for (int j = 0; j < col; j++) {
	                dist[i][j] = Integer.MAX_VALUE;

	                if (list.get(i).get(j) == 1) {
	                    // distace of '1' from itself is always 0
	                    dist[i][j] = 0;

	                    // make pair and push it in queue
	                    q.add(new Pair(i, j));
	                }
	            }
	        }

	        // now do bfs traversal
	        // pop element from queue one by one untill it gets empty
	        // pair element to hold the currently poped element
	        Pair poped;
	        while (!q.isEmpty()) {
	            poped = q.peek();
	            q.poll();

	            // coordinate of currently poped node
	            int x = poped.first;
	            int y = poped.second;

	            // now check for all adjancent of poped element
	            for (int i = 0; i < 4; i++) {
	                int adjx = x + newx[i];
	                int adjy = y + newy[i];

	                // if new coordinates are within boundary and
	                // we can minimize the distance of adjancent
	                // then update the distnace of adjacent in
	                // distance matrix and push this adjacent
	                // element in queue for further bfs
	                if (adjx >= 0 && adjx < row && adjy >= 0 && adjy < col &&
	                    dist[adjx][adjy] > dist[x][y] + 1) {
	                    // update distance
	                    dist[adjx][adjy] = dist[x][y] + 1;
	                    q.add(new Pair(adjx, adjy));
	                }
	            }
	        }

	        ArrayList<ArrayList<Integer>> sol = new ArrayList<>(row);

	        for (int i = 0; i < row; i++) {
	            ArrayList<Integer> temp = new ArrayList<>(col);
	            sol.add(i, temp);
	        }

	        for (int i = 0; i < row; i++) {
	            for (int j = 0; j < col; j++) {
	                sol.get(i).add(j, dist[i][j]);
	            }
	        }

	        // new Driver_class().print(sol, row, col);
	        return sol;
	    }

}
