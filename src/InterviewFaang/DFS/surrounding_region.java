package DFS;
import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/replace-os-with-xs/0
public class surrounding_region {
	int visited[][];
    int r,c;
	public static void main(String[] args) {
	 char arr[][] = {{'X', 'X', 'X', 'X'},{'X', 'O', 'O', 'X'},{'X', 'X', 'O', 'X'},{'X', 'O', 'X', 'X'}};
	 surrounding_region ob1=new surrounding_region();
	 ob1.solve(arr);
	 for(char x[]:arr) {
		 System.out.println(Arrays.toString(x));
	 }
	}
	public void solve(char a[][]) {
        r=a.length;
        c=a[0].length;
        visited=new int[r+1][c+1];
        
        int i=0;
        int j=0;
        for(j=0;j<c;j++) // left
        {
            if(a[i][j]=='O')
            dfs(a,i,j);
        }
         i=r-1;
        for(j=0;j<c;j++) // right
        {
            if(a[i][j]=='O')
            dfs(a,i,j);
        }
        j=0;
        for(i=0;i<r;i++)
        {
            if(a[i][j]=='O')
            dfs(a,i,j);
        }
        j=c-1;
        for(i=0;i<r;i++)
        {
            if(a[i][j]=='O')
            dfs(a,i,j);
        }
        
        for(i=0;i<r;i++)
        {
            for(j=0;j<c;j++)
            {
                if(a[i][j]=='O'&&visited[i][j]!=1)
                {
                	a[i][j]='X';
                }
            }
        }
        return ;
        
        
    }
    
    void dfs(char a[][],int i,int j)
    {
    	if(i>=r||j>=c||i<0||j<0||a[i][j]=='X'||visited[i][j]==1)
        return ;
        
        visited[i][j]=1;
        
        dfs(a,i,j+1);
        dfs(a,i,j-1);
        dfs(a,i+1,j);
        dfs(a,i-1,j);
    }

}
