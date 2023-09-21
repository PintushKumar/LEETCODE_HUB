class Pair {
    int row;  // Row coordinate of the cell
    int col;  // Column coordinate of the cell
    int dist; // Distance from the start cell to this cell

    Pair(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;           // Number of rows in the grid
        int m = grid[0].length;        // Number of columns in the grid
        int des_row = n - 1, des_col = n - 1;  // Destination coordinates
        Queue<Pair> q = new ArrayDeque<>();  // Create a queue for BFS traversal
        q.add(new Pair(0, 0, 1));  // Add the starting cell (0,0) with distance 1

        while (q.size() > 0) {
            Pair temp = q.remove();  // Dequeue the cell from the queue
            int row = temp.row;     // Get the row coordinate of the current cell
            int col = temp.col;     // Get the column coordinate of the current cell
            int dist = temp.dist;   // Get the distance to the current cell

            if (row >= 0 && row < n && col >= 0 && col < m && grid[row][col] != 1) {
                // Check if the current cell is within bounds and not blocked (1)

                if (row == des_row && col == des_col) {
                    // If we reached the destination cell, return the distance
                    return temp.dist;
                }

                grid[row][col] = 1;  // Mark the current cell as visited

                // Add adjacent cells to the queue with an increased distance
                q.add(new Pair(row - 1, col, dist + 1));  // Up
                q.add(new Pair(row + 1, col, dist + 1));  // Down
                q.add(new Pair(row, col - 1, dist + 1));  // Left
                q.add(new Pair(row, col + 1, dist + 1));  // Right
                q.add(new Pair(row + 1, col + 1, dist + 1));  // Diagonal Down-Right
                q.add(new Pair(row - 1, col - 1, dist + 1));  // Diagonal Up-Left
                q.add(new Pair(row + 1, col - 1, dist + 1));  // Diagonal Down-Left
                q.add(new Pair(row - 1, col + 1, dist + 1));  // Diagonal Up-Right
            }
        }

        // If no path is found from the start to the destination, return -1
        return -1;
    }
}
