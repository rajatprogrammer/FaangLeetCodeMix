package DataStrucureTopicWise.Graph;

import java.util.Arrays;
public class findInterConnected {
	
	  int parent[];
	  int size[];

	public static void main(String[] args) {
		int N=6;
		int A[] = {1,2,4,5};
		int B[] = {2,3,5,6};
		
		findInterConnected ob1  = new findInterConnected();
		System.out.println(ob1.solution(A,B,N));

	}

	    public int solution(int[] A, int[] B, int N) {
	        parent = new int[N + 1];
	        size = new int[N + 1];

	        // Initialize parent and size
	        for (int i = 1; i <= N; i++) {
	            parent[i] = i;
	            size[i] = 1;
	        }

	        // Union operations
	        for (int i = 0; i < A.length; i++) {
	            unionBySize(A[i], B[i]);
	        }

	        // Find the largest component size
	        
	        System.out.println("data" + Arrays.toString(size));
	        int maxSize = 0;
	        for (int i = 1; i <= N; i++) {
	            maxSize = Math.max(maxSize, size[i]);
	        }

	        return maxSize;
	    }

	    public int find(int node) {
	        if (node != parent[node]) {
	            parent[node] = find(parent[node]); // Path compression
	        }
	        return parent[node];
	    }

	    public void unionBySize(int a, int b) {
	        int rootA = find(a);
	        int rootB = find(b);

	        if (rootA == rootB) return;

	        // Union by size
	        if (size[rootA] >= size[rootB]) {
	            parent[rootB] = rootA;
	            size[rootA] += size[rootB];
	        } else {
	            parent[rootA] = rootB;
	            size[rootB] += size[rootA];
	        }
	    }
	}

