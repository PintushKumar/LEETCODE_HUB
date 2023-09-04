//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    // This method converts 'B' to 'O' and 'O' to 'X' in the board
    public static void convert(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        // Iterate through the entire board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';  // Convert 'B' to 'O'
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';  // Convert 'O' to 'X'
                }
            }
        }
    }

    // This method checks if a cell at (i, j) is a valid 'O' cell
    public static boolean isValid(int i, int j, int n, int m, char[][] board) {
        if (i >= 0 && i < n && j >= 0 && j < m && board[i][j] == 'O') {
            return true;  // The cell is valid if it's within the bounds and contains 'O'
        }
        return false;
    }

    // This method performs depth-first search (DFS) to mark connected 'O' cells as 'B'
    public static void dfs(char[][] board, int i, int j, int n, int m) {
        board[i][j] = 'B';  // Mark the current cell as 'B'

        // Recursively visit neighboring cells if they are valid 'O' cells
        if (isValid(i + 1, j, n, m, board)) {
            dfs(board, i + 1, j, n, m);
        }
        if (isValid(i - 1, j, n, m, board)) {
            dfs(board, i - 1, j, n, m);
        }
        if (isValid(i, j + 1, n, m, board)) {
            dfs(board, i, j + 1, n, m);
        }
        if (isValid(i, j - 1, n, m, board)) {
            dfs(board, i, j - 1, n, m);
        }
    }

    // This method fills the board according to the problem requirements
    static char[][] fill(int n, int m, char board[][]) {
        // Iterate through the board's edges
        for (int i = 0; i < n; i++) {
            int j = 0;
            if (board[i][j] == 'O') {
                dfs(board, i, j, n, m);  // Start DFS from the left edge
            }

            j = m - 1;
            if (board[i][j] == 'O') {
                dfs(board, i, j, n, m);  // Start DFS from the right edge
            }
        }

        for (int j = 0; j < m; j++) {
            int i = 0;
            if (board[i][j] == 'O') {
                dfs(board, i, j, n, m);  // Start DFS from the top edge
            }

            i = n - 1;
            if (board[i][j] == 'O') {
                dfs(board, i, j, n, m);  // Start DFS from the bottom edge
            }
        }

        convert(board);  // Convert the remaining 'O's to 'X's
        return board;  // Return the modified board
    }
}
