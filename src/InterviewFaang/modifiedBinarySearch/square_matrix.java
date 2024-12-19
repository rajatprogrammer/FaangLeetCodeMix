package InterviewFaang.modifiedBinarySearch;
//https://www.geeksforgeeks.org/find-the-row-with-maximum-number-1s/
public class square_matrix {

	public static void main(String[] args) {
		int arr[][] = {
				{0,1 ,1 ,1},
				{0,0 ,1 ,1},
				{1,1 ,1 ,1},
				{0,0, 0, 0}
		};
		System.out.print(rowWithMax1s(arr));

	}
	public static int rowWithMax1s(int mat[][]) {
		int max_row_index=0;
		int max = first(mat[0],0,mat[0].length-1);
		for(int i=1;i<mat.length;i++) {
			int C=mat[i].length-1;
			if(max!=-1 && mat[i][C-max]==1) {
				int index = first(mat[i],0,C-max);
				 if (index != -1 && C-index > max) 
		            { 
		                max = C - index; 
		                max_row_index = i; 
		            }    
			}else {
				max=first(mat[i],0,mat[i].length-1);
			}
		}
		
		return max_row_index;
		
	}
	public static int first(int arr[],int low,int high) {
		if(low<=high) {
			int mid = (low+high)/2;
			if(mid==0 || (arr[mid-1]==0 && arr[mid]==1)) {
				return mid;
			}
			else if(arr[mid]==1) {
				return first(arr,low,mid-1);
			}else {
				return first(arr,mid+1,high);
			}
		}
		return -1;
	}

}
