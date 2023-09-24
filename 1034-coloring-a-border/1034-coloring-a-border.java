class Solution {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int newColor) {
        int n = grid.length;   // Number of rows
        int m = grid[0].length; // Number of columns
        
        int oldColor = grid[r0][c0]; // Original color of the starting cell
        boolean[][] visited = new boolean[n][m]; // To track visited cells
        
        if (oldColor != newColor) {
            dfs(grid, r0, c0, n, m, oldColor, newColor, visited);
        }
        
        return grid; // Return the updated grid
    }
    
    public void dfs(int[][] grid, int i, int j, int n, int m, int oldColor, int newColor, boolean[][] visited) {
        // Check if the cell is out of bounds or has the new color or is already visited
        if (i >= n || i < 0 || j >= m || j < 0 || grid[i][j] != oldColor || visited[i][j]) {
            return;
        }
        
        visited[i][j] = true; // Mark the cell as visited
        boolean border = false; // A flag to check if the cell is on the border
        
        // Check if the cell is on the border or adjacent cells have a different color
        if (i == 0 || j == 0 || j == m - 1 || i == n - 1 ||
            grid[i + 1][j] != oldColor || grid[i - 1][j] != oldColor || 
            grid[i][j - 1] != oldColor || grid[i][j + 1] != oldColor) {
            border = true;
        }
        
        // Recursively explore neighboring cells
        dfs(grid, i + 1, j, n, m, oldColor, newColor, visited);
        dfs(grid, i - 1, j, n, m, oldColor, newColor, visited);
        dfs(grid, i, j + 1, n, m, oldColor, newColor, visited);
        dfs(grid, i, j - 1, n, m, oldColor, newColor, visited);

        // If the cell is on the border, update its color to the new color
        if (border) {
            grid[i][j] = newColor;
        }
    }
}
