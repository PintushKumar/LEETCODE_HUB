//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution {
    boolean dfs(ArrayList<ArrayList<Integer>> adj, int currNode, boolean[] visited, int countNode, int N) {
        if (countNode == N) {
            return true;
        }
        visited[currNode] = true;
        for (int nbr : adj.get(currNode)) {
            if (!visited[nbr] ) {
                if (dfs(adj, nbr, visited, countNode + 1, N)) {
                    return true;
                }
            }
        }
        visited[currNode] = false; // Reset the visited status when backtracking.
        return false;
    }

    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : Edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);  // Add the reverse edge for an undirected graph
        }
        boolean visited[] = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                if (dfs(adj, i, visited, 1, N)) {  // Pass -1 as the previous node for the first node.
                    return true;
                }
            }
        }
        return false;
    }
}

