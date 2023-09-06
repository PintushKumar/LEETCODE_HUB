//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return Breadth First Traversal of the given graph.
    public ArrayList<Integer> bfsOfGraph(int numVertices, ArrayList<ArrayList<Integer>> adjacencyList) {
        // Initialize an ArrayList to store the BFS traversal result.
        ArrayList<Integer> bfsTraversal = new ArrayList<>();

        // Create a boolean array to keep track of visited nodes.
        boolean[] visited = new boolean[numVertices];

        // Create a queue for BFS traversal.
        Queue<Integer> queue = new ArrayDeque<>();

        // Start BFS from the first vertex (vertex 0).
        int startVertex = 0;
        visited[startVertex] = true; // Mark the starting vertex as visited.
        queue.add(startVertex); // Add the starting vertex to the queue.

        // Perform BFS traversal.
        while (!queue.isEmpty()) {
            // Remove the current node from the queue.
            int currentNode = queue.remove();

            // Add the current node to the BFS traversal result.
            bfsTraversal.add(currentNode);

            // Iterate through neighbors of the current node.
            for (int neighbor : adjacencyList.get(currentNode)) {
                // Check if the neighbor has not been visited.
                if (!visited[neighbor]) {
                    visited[neighbor] = true; // Mark the neighbor as visited.
                    queue.add(neighbor); // Add the neighbor to the queue for further exploration.
                }
            }
        }

        // Return the BFS traversal result.
        return bfsTraversal;
    }
}
