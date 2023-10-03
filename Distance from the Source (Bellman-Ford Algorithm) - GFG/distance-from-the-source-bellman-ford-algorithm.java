//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<>();
                t1.add(u);
                t1.add(v);
                t1.add(w);
                edges.add(t1);
            }

            int S = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            int[] ptr = ob.bellman_ford(V, edges, S);

            for (i = 0; i < ptr.length; i++) System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/


class Solution {
    static int[] bellman_ford(int n, ArrayList<ArrayList<Integer>> edges, int S) {
        // Create an array to store the shortest distances from the source to all vertices.
        int dist[] = new int[n];
        
        // Initialize the distance array with a large value (10^8) to represent infinity.
        Arrays.fill(dist, 100000000);
        
        // The distance from the source to itself is always 0.
        dist[S] = 0;
        
        // Perform n-1 iterations for relaxation (finding shorter paths).
        for(int i = 1; i <= n-1; i++) {
            // Iterate through all edges in the graph.
            for(ArrayList<Integer> edge : edges) {
                int u = edge.get(0);  // Starting vertex of the edge.
                int v = edge.get(1);  // Ending vertex of the edge.
                int wt = edge.get(2); // Weight (distance) of the edge.

                // If dist[u] is not infinity (i.e., a path to u exists) and
                // the total distance from S to v through u is shorter than
                // the current distance to v, update dist[v].
                if (dist[u] != 100000000 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        
        // Check for negative cycles by iterating through the edges again.
        for(ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);
            
            // If a shorter path is still found in this phase, it means there is a negative cycle.
            if (dist[u] != 100000000 && dist[u] + wt < dist[v]) {
                int arr[] = {-1}; // Return an array containing -1 to indicate the presence of a negative cycle.
                return arr;
            }
        }
        
        // Return the array of shortest distances from the source to all vertices.
        return dist;
    }
}
