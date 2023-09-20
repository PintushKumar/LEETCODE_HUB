//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            Solution obj = new Solution();
            int ans = obj.xShape(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends




class Solution
{
    public void dfs(char [][] grid , int i , int j , int n , int m ){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j] =='O'){
            return;
        }
        
        // mark 
        
        grid[i][j] = 'O';
        
        dfs(grid , i-1 , j , n , m);
        dfs(grid , i+1 , j , n , m);
        dfs(grid , i , j-1 , n , m);
        dfs(grid , i , j+1 , n , m);
    }
    //Function to find the number of 'X' total shapes.
    public int xShape(char[][] grid)
    {
        // code here
        int n = grid.length;
        int m = grid[0].length;
        
        int count = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='X'){
                    count++;
                    dfs(grid , i , j , n , m);
                }
            }
        }
        
        return count;
    }
}