package graph;
//https://www.interviewbit.com/problems/black-shapes/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class black_sheep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public int black(ArrayList<String> A) {
        Queue<int[]> q = new LinkedList<>();
        int visited[][] = new int[A.size()][A.get(0).length()];
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};
        int count = 0;
        for(int i=0; i<A.size(); i++) {
            String str = A.get(i);
            for(int j=0; j<str.length(); j++) {
                if(str.charAt(j) == 'X' && visited[i][j] == 0) {
                    int temp[] = new int[2];
                    temp[0] = i;
                    temp[1] = j;
                    q.add(temp);
                    count++;
                    while(!q.isEmpty()) {
                        temp = q.remove();
                        for(int k=0; k<4; k++) {
                            int x = temp[0] + dx[k];
                            int y = temp[1] + dy[k];
                            if(x >= 0 && x < A.size() && y>=0 && y < str.length()) {
                                if(A.get(x).charAt(y) == 'X' && visited[x][y] == 0) {
                                    int temp1[] = new int[2];
                                    temp1[0] = x;
                                    temp1[1] = y;
                                    q.add(temp1);
                                    visited[x][y] = 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
