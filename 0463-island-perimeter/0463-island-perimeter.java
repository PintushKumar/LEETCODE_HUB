class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int periMeter = 0;

        // Loop through each cell in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    // Check adjacent cells (up, down, left, right) and count perimeter
                    if (i == 0 || grid[i - 1][j] == 0) periMeter++; // Up
                    if (i == n - 1 || grid[i + 1][j] == 0) periMeter++; // Down
                    if (j == 0 || grid[i][j - 1] == 0) periMeter++; // Left
                    if (j == m - 1 || grid[i][j + 1] == 0) periMeter++; // Right
                }
            }
        }

        return periMeter;
    }
}
