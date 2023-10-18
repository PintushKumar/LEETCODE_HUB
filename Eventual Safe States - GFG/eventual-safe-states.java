//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean isSafe(List<List<Integer>> adj , int currNode , int visited[]){
        if(visited[currNode]==1){
            return false;
        }
        if(visited[currNode] ==2 ){
            return true;
        }
        visited[currNode] = 1;
        for(int nbr : adj.get(currNode)){
            if(visited[nbr]== 1){
                return false;
            }
            if(visited[nbr]==2){
                continue;
            }
            if(!isSafe(adj , nbr , visited)){
                return false;
            }
        }
        visited[currNode] = 2;
        return true;
    }
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        // Your code here
        List<Integer> res = new ArrayList<>();
        int visited [] = new int [V];
        for(int i=0;i<V;i++){
            if(isSafe(adj , i , visited)){
                res.add(i);
            }
        }
        return res;
    }
}
