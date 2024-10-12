package matrix;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/find-whether-path-two-cells-matrix/
//Adobe
public class find_path {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = {{ 0, 3, 1, 0 }, 
				{ 3, 0, 3, 3 }, 
				{ 2, 3, 0, 3 }, 
				{ 0, 3, 3, 3 }};
		System.out.println(is_possible(mat,mat.length));
	}
	public static int is_possible(int M[][], int N) {
		int dir[][] = {{0,1},{1,0},{-1,0},{0,-1}};
		boolean[][] visited = new boolean[M.length][M[0].length];
		Queue<int[]> q = new LinkedList<int[]>();
		for(int i=0;i<M.length;i++) {
			boolean break_flag=false;
			for(int j=0;j<M[0].length;j++) {
				if(M[i][j]==1) {
					int temp[] = new int[2];
					temp[0]=i;
					temp[1]=j;
					q.add(temp);
					visited[i][j]=true;
					break_flag=true;
					break;
				}
			}
			if(break_flag) {
				break;
			}
		}
		while(!q.isEmpty()) {
			int temp[] = q.poll();
			int i=temp[0];
			int j=temp[1];
			for(int itr=0;itr<dir.length;itr++) {
				int left=i+dir[itr][0];
				int right=j+dir[itr][1];
				if(left<0||right<0||left>=M.length || right>=M[0].length || M[left][right]==0 || visited[left][right]) {
					continue;
				}	
				if(M[left][right]==3) {
					int mov[] = new int[2];
					mov[0]=left;
					mov[1]=right;
					q.add(mov);
				}
				if(M[left][right]==2) {
					return 1;
				}
				visited[left][right]=true;
			}
		}
		
		return 0;
        
    }

}
