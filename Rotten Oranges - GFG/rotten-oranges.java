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
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Pair{
    int row ;
    int col;
    Pair(int row , int col){
        this.row = row;
        this.col = col;
    }
}
class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int fresh =0;
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Pair> q = new ArrayDeque<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i, j));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        
        if(fresh == 0){
            return 0;
        }
        
        int time =0;
        while(q.size()>0){
            int size = q.size();
            int temp =0;
            while(size-->0){
                Pair p = q.remove();
                if(p.row-1>=0 && grid[p.row-1][p.col]==1){
                    grid[p.row-1][p.col]=2;
                    q.add(new Pair(p.row-1 , p.col));
                    temp++;
                }
                if(p.row+1<n && grid[p.row+1][p.col]==1){
                    grid[p.row+1][p.col]=2;
                    q.add(new Pair(p.row+1 , p.col));
                    temp++;
                }
                if(p.col-1>=0 && grid[p.row][p.col-1]==1){
                    grid[p.row][p.col-1]=2;
                    q.add(new Pair(p.row , p.col-1));
                    temp++;
                }
                if(p.col+1<m && grid[p.row][p.col+1]==1){
                    grid[p.row][p.col+1]=2;
                    q.add(new Pair(p.row , p.col+1));
                    temp++;
                }
            }
            if(temp != 0){
                time++;
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    time = 0;
                    break;
                }
            }
        }
        
        return (time ==0)? -1:time;
        
    }
}