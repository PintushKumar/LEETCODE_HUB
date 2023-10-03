//{ Driver Code Starts
//Initial Template for Java

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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int isNegativeWeightCycle(int n, int[][] edges) {
        // Create an array to store the shortest distances from the source to all vertices.
        int dist[] = new int[n];

        // Initialize the distance array with a large value (10^8) to represent infinity.
        Arrays.fill(dist, 100000000);

        // The distance from the source to itself is always 0.
        dist[0] = 0;

        // Perform n-1 iterations for relaxation (finding shorter paths).
        for (int i = 1; i <= n - 1; i++) {
            // Iterate through all edges in the graph.
            for (int[] edge : edges) {
                int u = edge[0];  // Starting vertex of the edge.
                int v = edge[1];  // Ending vertex of the edge.
                int wt = edge[2]; // Weight (distance) of the edge.

                // If the total distance from S to v through u is shorter than
                // the current distance to v, update dist[v].
                if (dist[u] != 100000000 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Check for negative cycles by iterating through the edges again.
        for (int[] edge : edges) {
            int u = edge[0];  // Starting vertex of the edge.
            int v = edge[1];  // Ending vertex of the edge.
            int wt = edge[2]; // Weight (distance) of the edge.

            // If a shorter path is still found in this phase, it means there is a negative cycle.
            if (dist[u] + wt < dist[v]) {   //here no need check Dist[u] != 1e8
                return 1;
            }
        }

        // If no negative cycle is found after all iterations, return 0.
        return 0;
    }
}
