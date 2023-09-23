//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public void dfs(int grid[][] , int srow , int scol , int i , int j , int n , int m  , ArrayList<String> list){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]==0){
            return;
        }
        int row = i-srow;
        int col = j-scol;
        String s = row +""+col;
        list.add(s);
        grid[i][j]=0;
        dfs(grid , srow , scol , i+1 , j , n , m , list);
        dfs(grid , srow , scol , i , j-1 , n , m , list);
        dfs(grid , srow , scol , i-1 , j , n , m , list);
        dfs(grid , srow , scol , i , j+1 , n , m , list);
    }
//   void dfs(int r,int c,int[][] grid,boolean [][] vis,int srow,int scol,ArrayList<String>list){
//         int n = grid.length;
//         int m = grid[0].length;
//         vis[r][c] = true;
//         int row = r - srow;
//         int col = c - scol;
//         //Storing row col String in Arraylist
//         String str = row+""+col;
//         list.add(str);
//         int [] dirX = {-1,0,1,0};
//         int [] dirY = {0,-1,0,1};
//         for(int i = 0; i < 4; i++){
//             int nrow = r+dirX[i];
//             int ncol = c+dirY[i];
//             if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && vis[nrow][ncol] == false && grid[nrow][ncol] == 1){
//                 dfs(nrow,ncol,grid,vis,srow,scol,list);
//             }
//         }
//     }
 
    int countDistinctIslands(int[][] grid) {
         int n = grid.length;
         int m = grid[0].length;
         HashSet<ArrayList<String>>set = new HashSet<>();
       //  boolean [][] vis = new boolean[n][m];
         for(int i = 0; i < n; i++){
             for(int j = 0; j < m; j++){
                 if( grid[i][j] == 1){
                     ArrayList<String>list = new ArrayList<>();
                     dfs(grid , i ,j , i , j , n , m , list);
                     set.add(list);
                 }
             }
         }
         return set.size();
}
}