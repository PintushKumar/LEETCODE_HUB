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
    public static void dfs(ArrayList<ArrayList<Integer>> adj , int currNode , boolean visited [] , int n ){
        visited[currNode]=true; // mark visited
        for(int i=0;i<n;i++){
            if(!visited[i] && adj.get(i).get(currNode)==1){
                dfs(adj , i , visited , n);
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        boolean visited[] = new boolean[V+1]; // keep track of visited or not 
        int count =0; // number of provinces
        // iterate each node of the graph
        for(int i=0;i<V;i++){
            if(!visited[i]){
                count++;
                dfs(adj , i , visited , V);
            }
        }
        return count;
    }
};