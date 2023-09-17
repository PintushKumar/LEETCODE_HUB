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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int s = Integer.parseInt(S[2]);
            int d = Integer.parseInt(S[3]);
            int[][] edges = new int[m][2];
            for(int i = 0; i < m; i++){
                String[] S1 = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(S1[0]);
                edges[i][1] = Integer.parseInt(S1[1]);
            }
            Solution obj = new Solution();
            int ans = obj.possible_paths(edges, n, s, d);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void dfs(ArrayList<ArrayList<Integer>> adj , int s , int d , int count[] , boolean [] visited){
        visited[s]=true;
        if(s==d){
            count[0]++;
        }else{
            for(int v:adj.get(s)){
                if(!visited[v]){
                    dfs(adj , v,d , count , visited);
                }
            }
        }
        
        visited[s]=false;
    }
    public int possible_paths(int[][] edges, int n, int s, int d)
    {
        // Code here 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        
        int count[]={0};
        boolean visited [] = new boolean[n];
        dfs(adj , s , d , count , visited);
        
        return count[0];
    }
}