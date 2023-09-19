class Solution {
    // Depth-first search (DFS) function to explore land cells and mark them as visited.
    public void dfs(int[][] grid, int i, int j, int n, int m) {
        // Base cases to terminate the recursion:
        // 1. If the current cell is out of bounds (i or j is less than 0 or greater than or equal to n or m).
        // 2. If the current cell is water (grid[i][j] == 1), we return without further exploration.
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 1) {
            return;
        }

        // Mark the current cell as visited (grid[i][j] = 1).
        grid[i][j] = 1;

        // Recursively explore neighboring cells in all four directions (up, down, left, right).
        dfs(grid, i - 1, j, n, m); // Up
        dfs(grid, i + 1, j, n, m); // Down
        dfs(grid, i, j - 1, n, m); // Left
        dfs(grid, i, j + 1, n, m); // Right
    }

    // Function to count the number of closed islands in the grid.
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Iterate through all cells in the grid to initiate DFS from boundary cells.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Start DFS from cells at the boundary (i or j is 0 or n-1 or m-1).
                if (i * j == 0 || i == n - 1 || j == m - 1) {
                    dfs(grid, i, j, n, m);
                }
            }
        }

        int isLand = 0; // Initialize a counter for closed islands.

        // Count the number of closed islands by iterating through the grid.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If a cell is still unvisited (grid[i][j] == 0), it forms a closed island.
                if (grid[i][j] == 0) {
                    isLand++; // Increment the count of closed islands.
                    dfs(grid, i, j, n, m); // Mark the entire island as visited.
                }
            }
        }

        return isLand; // Return the count of closed islands.
    }
}
