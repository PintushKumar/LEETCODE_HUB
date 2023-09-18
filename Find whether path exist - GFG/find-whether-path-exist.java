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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}
// } Driver Code Ends



// class Solution {
//     // Helper function to perform depth-first search
//     public boolean dfs(int[][] grid, int row, int col, int numRows, int numCols) {
//         // Base cases for recursion
//         if (row < 0 || row >= numRows || col < 0 || col >= numCols || grid[row][col] == 0) {
//             return false; // Out of bounds or a wall, cannot proceed.
//         }
//         if (grid[row][col] == 2) {
//             return true; // Destination reached.
//         }
        
//         // Mark the current cell as visited (0) to avoid infinite loops.
//         grid[row][col] = 0;
        
//         // Recursively check neighboring cells
//         boolean left = dfs(grid, row - 1, col, numRows, numCols);   // Move left
//         boolean right = dfs(grid, row + 1, col, numRows, numCols);  // Move right
//         boolean up = dfs(grid, row, col - 1, numRows, numCols);     // Move up
//         boolean down = dfs(grid, row, col + 1, numRows, numCols);   // Move down
        
//         // Return true if any of the recursive calls found a path to the destination.
//         return left || right || up || down;
//     }
    
//     // Function to find whether a path exists from the source to destination.
//     public boolean is_Possible(int[][] grid) {
//         // Get the dimensions of the grid
//         int numRows = grid.length;
//         int numCols = grid[0].length;
        
//         // Iterate through the grid to find the source (1)
//         for (int i = 0; i < numRows; i++) {
//             for (int j = 0; j < numCols; j++) {
//                 if (grid[i][j] == 1) {
//                     // Start DFS from the source
//                     return dfs(grid, i, j, numRows, numCols);
//                 }
//             }
//         }
        
//         // If no source (1) is found, return false as there's no path.
//         return false;
//     }
// }



class Solution {
    // Function to find whether a path exists from the source to destination using BFS.
    public boolean is_Possible(int[][] grid) {
        // Get the dimensions of the grid
        int numRows = grid.length;
        int numCols = grid[0].length;
        
        // Initialize a queue for BFS
        Queue<int[]> queue = new ArrayDeque<>();
        
        // Find the source (1) and add it to the queue
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    break; // Exit the loop since we found the source
                }
            }
        }
        
        // Perform BFS by manually checking all four directions
        while (!queue.isEmpty()) {
            int[] currentCell = queue.remove();
            int row = currentCell[0];
            int col = currentCell[1];
            
            // Check if the current cell is the destination (2)
            if (grid[row][col] == 2) {
                return true; // Path from source to destination exists
            }
            
            // Mark the current cell as visited
            grid[row][col] = 0;
            
            // Check up
            if (row > 0 && grid[row - 1][col] != 0) {
                queue.add(new int[]{row - 1, col});
            }
            
            // Check down
            if (row < numRows - 1 && grid[row + 1][col] != 0) {
                queue.add(new int[]{row + 1, col});
            }
            
            // Check left
            if (col > 0 && grid[row][col - 1] != 0) {
                queue.add(new int[]{row, col - 1});
            }
            
            // Check right
            if (col < numCols - 1 && grid[row][col + 1] != 0) {
                queue.add(new int[]{row, col + 1});
            }
        }
        
        // If the queue becomes empty and destination (2) is not reached, return false
        return false;
    }
}
