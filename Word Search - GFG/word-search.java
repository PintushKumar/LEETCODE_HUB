//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      char a[][] = new char[n][m];
      sc.nextLine();
      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++)
         a[i][j]=sc.next().charAt(0);
      }
      String word=sc.next();
      Solution obj = new Solution();
      int ans = obj.wordSearch(a,word) ? 1 : 0;
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int indx =0;
    public static boolean dfs(char[][]board , int i , int j , int n , int m , String word , int indx){
        if(indx == word.length()){
            return true;
        }
        if(i<0 || i>=n || j<0 || j>=m || board[i][j] != word.charAt(indx)){
            return false;
        }
        
        char ch = board[i][j];
        board[i][j] = '*';
        
        boolean up = dfs(board , i-1 , j , n, m , word , indx+1);
        boolean down = dfs(board , i+1 , j , n, m , word , indx+1);
        boolean left = dfs(board , i , j-1 , n, m , word , indx+1);
        boolean right = dfs(board , i , j+1 , n, m , word , indx+1);
        
        board[i][j]=ch;
        
        return up || down || left || right;
    }
  public static boolean wordSearch(char board[][],String word) {
    // code here
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board , i , j , n , m  , word , 0)==true){
                        return true;
                    }
                }
            }
        }
        return false;
  }
}
     