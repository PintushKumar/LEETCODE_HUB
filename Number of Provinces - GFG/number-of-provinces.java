//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    // Depth-First Search (DFS) function to explore connected cities in a province.
    public static void dfs(ArrayList<ArrayList<Integer>> adjacencyMatrix, int n, int node, boolean[] visited) {
        visited[node] = true; // Mark the current city as visited.

        // Iterate through all cities to check for connections.
        for (int i = 0; i < n; i++) {
            if (!visited[i] && adjacencyMatrix.get(node).get(i) == 1) {
                dfs(adjacencyMatrix, n, i, visited); // Recursively visit connected city.
            }
        }
    }

    // Function to find the number of provinces in the given graph.
    static int numProvinces(ArrayList<ArrayList<Integer>> adjacencyMatrix, int V) {
        int componentCount = 0; // Initialize the count of provinces.
        boolean visited[] = new boolean[V]; // Create an array to track visited cities.

        // Iterate through all cities.
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adjacencyMatrix, V, i, visited); // Explore connected cities in the province.
                componentCount++; // Increment the province count for each unvisited city.
            }
        }

        return componentCount; // Return the total number of provinces.
    }
}
