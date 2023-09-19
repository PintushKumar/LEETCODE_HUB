//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    void destroyDFS(int grid[][] , int i , int j , int  n , int m ){
        if(i<0 || i>= n || j<0 || j>=m || grid[i][j]==0){
            return;
        }
        grid[i][j]=0;
        destroyDFS(grid , i-1 , j , n , m); // up
        destroyDFS(grid , i+1 , j , n , m); // down
        destroyDFS(grid , i , j-1 , n , m); // left
        destroyDFS(grid , i , j+1 , n , m); // right
    }
    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i*j == 0 || i == n-1 || j == m-1 ){
                    destroyDFS(grid , i , j , n , m );
                }
            }
        }
        
        int enclaves = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    enclaves++;
                }
            }
        }
        
        return enclaves;
    }
}