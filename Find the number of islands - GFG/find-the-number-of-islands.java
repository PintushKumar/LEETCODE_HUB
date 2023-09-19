//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Depth-First Search (DFS) function to explore connected land cells
    public void dfs(char[][] grid, int i, int j, int n, int m) {
        // Base case: If the current cell is out of bounds or is water ('0'), return
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == '0') {
            return;
        }
        
        // Mark the current cell as visited by changing it to '0'
        grid[i][j] = '0';  

        // Recursively visit neighboring cells
        dfs(grid, i - 1, j, n, m);  // Up
        dfs(grid, i + 1, j, n, m);  // Down
        dfs(grid, i, j - 1, n, m);  // Left
        dfs(grid, i, j + 1, n, m);  // Right
        dfs(grid, i - 1, j - 1, n, m);  // Upper left diagonal
        dfs(grid, i + 1, j + 1, n, m);  // Lower right diagonal
        dfs(grid, i - 1, j + 1, n, m);  // Upper right diagonal
        dfs(grid, i + 1, j - 1, n, m);  // Lower left diagonal
    }

    // Function to find the number of islands in the grid
    public int numIslands(char[][] grid) {
        int n = grid.length;    // Number of rows
        int m = grid[0].length; // Number of columns
        int islands = 0;        // Count of islands

        // Loop through each cell in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If the current cell is land ('1'), mark it as part of an island and explore its connected land cells
                if (grid[i][j] == '1') {
                    islands++;
                    dfs(grid, i, j, n, m);  // Explore the island using DFS
                }
            }
        }

        // Return the total number of islands
        return islands;
    }
}
