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



class Solution
{
    void dfs(ArrayList<ArrayList<Integer>>adj , int node , boolean visited[]){
        visited[node]=true;
        for(int neighBour : adj.get(node)){
            if(visited[neighBour]==false){
                dfs(adj , neighBour , visited);
            }
        }
    }
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        boolean visited [] = new boolean[V];
        int ans =-1;
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                ans = i;
                dfs(adj , i , visited);
            }
        }
        
        // checking again // this is for handling components of graph 
        
        boolean visited2 [] = new boolean[V];
        dfs(adj , ans , visited2);
        for(boolean visit : visited2){
            if(!visit){
                return -1;
            }
        }
        
        return ans;
    }
}