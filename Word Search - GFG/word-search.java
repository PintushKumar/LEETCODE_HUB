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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean dfs(char[][]board , int i , int j , int n , int m , String word , int indx){
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
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
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


// class Solution {
//     public boolean dfs(char[][] board, int i, int j, int n, int m, String word, int indx, boolean[][] visited) {
//         if (indx == word.length()) {
//             return true;
//         }
//         if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || board[i][j] != word.charAt(indx)) {
//             return false;
//         }

//         visited[i][j] = true;

//         boolean up = dfs(board, i - 1, j, n, m, word, indx + 1, visited);
//         boolean down = dfs(board, i + 1, j, n, m, word, indx + 1, visited);
//         boolean left = dfs(board, i, j - 1, n, m, word, indx + 1, visited);
//         boolean right = dfs(board, i, j + 1, n, m, word, indx + 1, visited);

//         visited[i][j] = false;

//         return up || down || left || right;
//     }

//     public boolean isWordExist(char[][] board, String word) {
//         int n = board.length;
//         int m = board[0].length;
//         boolean[][] visited = new boolean[n][m];

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (board[i][j] == word.charAt(0) && dfs(board, i, j, n, m, word, 0, visited)) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }
