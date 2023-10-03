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

// class Solution {
//     public boolean  dfs(List<List<Integer>> adj , int currNode , boolean visited[]  , boolean dfsVisited[]){
//         visited[currNode]=true;
//         dfsVisited[currNode]=true;
//         for( int nbr : adj.get(currNode)){
//             if(!visited[nbr]){
//                 if( dfs(adj , nbr , visited , dfsVisited )){
//                     return true;
//                 }
//             }else if(dfsVisited[nbr]== true){
//                 return true;
//             }
//         }
//         dfsVisited[currNode]=false;
//         return false;
//     }
//     List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
//         // Your code here
//         boolean visited[] = new boolean [V];
//         boolean dfsVisited[] = new boolean [V];
//         for(int i=0;i<V;i++){
//             if(!visited[i]){
//                 dfs(adj , i , visited , dfsVisited);
//             }
//         }
//         List<Integer> res = new ArrayList<>();
        
//         for(int i=0;i<V;i++){
//             if(dfsVisited[i]==false){
//                 res.add(i);
//             }
//         }
//         return res;
//     }
// }

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> graphs) {
    
    
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int u = 0; u < V; u++) {
            for (int v : graphs.get(u)) {
                adj.get(v).add(u);
            }
        }
        
        int [] inDegree = new int[V];
        
        for(int u =0;u<V;u++){
            for(int v : adj.get(u)){
                inDegree[v]++;
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i=0;i<V; i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        
        boolean safe[] = new boolean[V];
        
        while(q.size()>0){
            int currNode = q.remove();
            safe[currNode] = true;
            for(int v: adj.get(currNode)){
                inDegree[v]--;
                if(inDegree[v]==0){
                    q.add(v);
                }
            }
        }
        
        List<Integer> resSafe = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            if(safe[i]==true){
                resSafe.add(i);
            }
        }
        
        return resSafe;
    }
}
