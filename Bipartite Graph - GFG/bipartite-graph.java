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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution {
    public boolean isBipartite(int numVertices, ArrayList<ArrayList<Integer>> adjList) {
        int[] vertexColors = new int[numVertices];
        Arrays.fill(vertexColors, -1); // Initialize all vertices as uncolored (-1)
        
        // 0 represents as green color
        // 1 represents as blue color

        // for (int startVertex = 0; startVertex < numVertices; startVertex++) {
        //     if (vertexColors[startVertex] == -1) { // If the vertex is uncolored
        //         // Start a DFS traversal from this uncolored vertex
        //         if (!dfs(adjList, startVertex, vertexColors, 0)) {
        //             return false; // If it's not bipartite, return false
        //         }
        //     }
        // }
        // // If the DFS traversal is successful for all components, the graph is bipartite
        // return true;
        
        
          for (int startVertex = 0; startVertex < numVertices; startVertex++) {
            if (vertexColors[startVertex] == -1) { // If the vertex is uncolored
                // Start a DFS traversal from this uncolored vertex
                if (!bfs(adjList, startVertex, vertexColors)) {
                    return false; // If it's not bipartite, return false
                }
            }
        }
        // If the DFS traversal is successful for all components, the graph is bipartite
        return true;
    }

    // public boolean dfs(ArrayList<ArrayList<Integer>> adjList, int currentVertex, int[] vertexColors, int currentColor) {
    //     vertexColors[currentVertex] = currentColor;

    //     for (int neighbor : adjList.get(currentVertex)) {
    //         if (vertexColors[neighbor] == vertexColors[currentVertex]) {
    //             return false; // If the neighbor has the same color as the current vertex, the graph is not bipartite
    //         } else if (vertexColors[neighbor] == -1) {
    //             int neighborColor = 1 - currentColor; // Toggle the color (0 to 1 or 1 to 0)

    //             if (!dfs(adjList, neighbor, vertexColors, neighborColor)) {
    //                 return false; // If the recursive call returns false, the graph is not bipartite
    //             }
    //         }
    //     }
    //     // If all neighbors are successfully colored, the graph is bipartite
    //     return true;
    // }
    
    
    public boolean bfs(ArrayList<ArrayList<Integer>> adjList, int currentVertex, int[] vertexColors){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(currentVertex);
        vertexColors[currentVertex] =1;  // we color currentVertex as blue
        while(q.size()>0){
            int curr = q.remove();
            for(int neighbor : adjList.get(curr)){
                if(vertexColors[neighbor]== vertexColors[curr]){
                    return false;
                }else if(vertexColors[neighbor]==-1){
                    vertexColors[neighbor] = 1-vertexColors[curr];
                    q.add(neighbor);
                }
            }
        }
        
        return true;
    }
}
