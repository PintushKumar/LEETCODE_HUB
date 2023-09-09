//{ Driver Code Starts
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
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


// class Solution {
    // public boolean isCycleDFS(ArrayList<ArrayList<Integer>> adj , int node , boolean visited[] , int parent ){
    //     visited[node] = true;
        
    //     for(int neighbor : adj.get(node)){
            
    //         if(neighbor == parent){
    //             continue;
    //         }
            
    //         if(visited[neighbor]){
    //             return true;
    //         }
            
    //         if(isCycleDFS(adj , neighbor , visited , node)){
    //             return true;
    //         }
    //     }
        
    //     return false;
    // }
    // // Function to detect cycle in an undirected graph.
    // public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    //     // Code here
    //     boolean visited[] = new boolean[V];
        
    //     for(int i=0;i<V;i++){
    //         if(!visited[i]){
    //             if(isCycleDFS(adj , i , visited , -1)){
    //                 return true;
    //             }
    //         }
    //     }
        
    //     return false;
    // }
// }


class Pair {
    int start;
    int parent;

    Pair(int start, int parent) {
        this.start = start;
        this.parent = parent;
    }
}

class Solution {
    public boolean isCyclicBFS(ArrayList<ArrayList<Integer>> adj, int start, boolean visited[]) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(start, -1));
        visited[start] = true;
        while (q.size() > 0) {
            Pair temp = q.remove();
            int curr = temp.start;
            int parent = temp.parent;
            for (int neighbor : adj.get(curr)) {
                if (!visited[neighbor]) {
                    q.add(new Pair(neighbor, curr));
                    visited[neighbor] = true;
                } else if (neighbor != parent) {
                    // Potential issue: This condition checks if the neighbor is not the parent,
                    // but it should also check if the neighbor is already visited to confirm a cycle.
                    return true;
                }
            }
        }
        return false;
    }

    // Function to detect a cycle in a directed graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclicBFS(adj, i, visited)) {
                    // Potential issue: If isCyclicBFS returns true, it indicates a cycle.
                    // You should return true here.
                    return true;
                }
            }
        }
        // Potential issue: If no cycle is found in any connected component of the graph,
        // you should return false here.
        return false;
    }
}
