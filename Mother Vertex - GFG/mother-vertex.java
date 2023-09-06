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
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends



class Solution {
    // Helper function for depth-first search (DFS).
    void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean visited[]) {
        visited[node] = true; // Mark the current node as visited.

        // Traverse neighbors of the current node.
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(adj, neighbor, visited); // Recursive call for unvisited neighbors.
            }
        }
    }

    // Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V]; // Array to track visited nodes.
        int potentialMotherVertex = -1; // Initialize a potential mother vertex.

        // Loop through all nodes in the graph.
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                potentialMotherVertex = i; // Update potential mother vertex.
                dfs(adj, i, visited); // Perform DFS from this node.
            }
        }

        // Checking again to handle components of the graph.
        boolean visited2[] = new boolean[V]; // Array to track visited nodes for the second DFS.
        dfs(adj, potentialMotherVertex, visited2); // Perform DFS from the potential mother vertex.

        // Check if all nodes are visited in the second DFS.
        for (boolean visit : visited2) {
            if (!visit) {
                return -1; // If not all nodes are visited, there's no mother vertex.
            }
        }

        return potentialMotherVertex; // Return the potential mother vertex.
    }
}
