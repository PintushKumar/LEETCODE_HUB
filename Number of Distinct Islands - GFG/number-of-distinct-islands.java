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
    // Recursive DFS function to explore an island starting from (srow, scol)
    public void dfs(int grid[][], int srow, int scol, int i, int j, int n, int m, ArrayList<String> list) {
        // Base cases for recursion
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0) {
            return;
        }

        // Calculate relative position to the starting cell (srow, scol)
        int row = i - srow;
        int col = j - scol;

        // Convert relative position to a string
        String s = row + "" + col;

        // Add the relative position to the list of positions for the island
        list.add(s);

        // Mark the current cell as visited (set it to 0)
        grid[i][j] = 0;

        // Recursively explore neighboring cells (up, down, left, and right)
        dfs(grid, srow, scol, i + 1, j, n, m, list);
        dfs(grid, srow, scol, i, j - 1, n, m, list);
        dfs(grid, srow, scol, i - 1, j, n, m, list);
        dfs(grid, srow, scol, i, j + 1, n, m, list);
    }

    // Function to count distinct islands in the given grid
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // HashSet to store unique island configurations
        HashSet<ArrayList<String>> set = new HashSet<>();

        // Iterate through the grid to find islands and store their configurations
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    // ArrayList to store the positions of the current island
                    ArrayList<String> list = new ArrayList<>();

                    // Explore the island and store its configuration
                    dfs(grid, i, j, i, j, n, m, list);

                    // Add the island's configuration to the HashSet
                    set.add(list);
                }
            }
        }

        // Return the count of distinct islands
        return set.size();
    }
}
