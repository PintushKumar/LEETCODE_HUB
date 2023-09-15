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
    public static void dfs(ArrayList<ArrayList<Integer>> adj ,int n , int node , boolean []visited){
        visited[node]=true;
        for(int i=0;i<n;i++){
            if(!visited[i] && adj.get(node).get(i)==1 ){
                dfs(adj ,n, i , visited);
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int component =0;
        boolean visited [] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(adj ,V, i , visited);
                component +=1;
            }
        }
        return component ;
    }
};