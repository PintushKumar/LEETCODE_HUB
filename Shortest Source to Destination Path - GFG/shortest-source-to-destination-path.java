//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair {
    int row;   // Row coordinate of the cell
    int col;   // Column coordinate of the cell
    int dist;  // Distance from the start cell to this cell
    
    Pair(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // Create a queue to perform breadth-first search (BFS)
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, 0, 0));  // Add the starting cell (0, 0) with distance 0
        
        while (q.size() > 0) {
            Pair temp = q.remove();  // Dequeue the cell from the queue
            int row = temp.row;     // Get the row coordinate of the current cell
            int col = temp.col;     // Get the column coordinate of the current cell
            int dist = temp.dist;   // Get the distance to the current cell
            
            // Check if the current cell is within bounds and not blocked (0)
            if (row >= 0 && row < N && col >= 0 && col < M && A[row][col] != 0) {
                if (row == X && col == Y) {
                    // If we reached the destination cell (X, Y), return the distance
                    return dist;
                }
                
                A[row][col] = 0;  // Mark the current cell as visited (set to 0)
                
                // Add adjacent cells to the queue with an increased distance
                q.add(new Pair(row + 1, col, dist + 1));  // Down
                q.add(new Pair(row - 1, col, dist + 1));  // Up
                q.add(new Pair(row, col + 1, dist + 1));  // Right
                q.add(new Pair(row, col - 1, dist + 1));  // Left
            }
        }
        
        // If no path is found from the start to the destination, return -1
        return -1;
    }
}
