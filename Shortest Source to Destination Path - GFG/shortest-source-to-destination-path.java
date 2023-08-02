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
    int first;  // Distance from source
    int second; // Row coordinate
    int third;  // Column coordinate

    Pair(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // If the source cell is blocked, return -1
        if (A[0][0] == 0) return -1;

        // Create a queue for storing cells with their distances from the source
        // in the form {dist, {cell coordinates pair}}.
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, 0, 0));

        // Arrays for representing possible movements: down, up, right, left
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        //{1, 0}: Move down one row.
        // {-1, 0}: Move up one row.
        // {0, 1}: Move right one column.
        // {0, -1}: Move left one column.
        while (!q.isEmpty()) {
            Pair temp = q.remove();
            int dis = temp.first;  // Distance of the current cell from the source
            int r = temp.second;   // Row coordinate of the current cell
            int c = temp.third;    // Column coordinate of the current cell

            // If the current cell is the destination, return the distance
            if (r == X && c == Y) return dis;

            // Explore all 4 directions from the current cell
            for (int i = 0; i < 4; i++) {
                int newr = r + dr[i];     // New row coordinate
                int newc = c + dc[i];     // New column coordinate

                // Check if the new coordinates are within bounds and the cell is not blocked
                if (newr >= 0 && newr < N && newc >= 0 && newc < M && A[newr][newc] == 1) {
                    A[newr][newc] = 0;  // Mark the cell as visited
                    // If the new cell is the destination, return the updated distance
                    if (newr == X && newc == Y) return dis + 1;
                    // Add the new cell to the queue with updated distance
                    q.add(new Pair(1 + dis, newr, newc));
                }
            }
        }
        // If no path is found from source to destination, return -1
        return -1;
    }
}


