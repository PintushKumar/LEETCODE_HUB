class Solution {
    public void dfs(char[][] grid, int row, int col, int numRows, int numCols) {
        // Base cases for recursion
        if (row < 0 || row >= numRows || col < 0 || col >= numCols || grid[row][col] == '0') {
            return ; // Out of bounds or a wall, cannot proceed.
        }
  
        grid[row][col] = '0';

        // Recursively check neighboring cells
       dfs(grid, row - 1, col, numRows, numCols);   // Move up
       dfs(grid, row + 1, col, numRows, numCols);  // Move down
       dfs(grid, row, col - 1, numRows, numCols);     // Move left
       dfs(grid, row, col + 1, numRows, numCols);   // Move right
        
    }
    
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] !='0'){
                    dfs(grid ,i,j,n ,m);
                    count++;
                }
            }
        }
        return count;
    }
}