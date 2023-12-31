//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/


// ********************** Detecting Cycle Using DFS ******************************

// class Solution {
//     public boolean isCyclicDFS(ArrayList<ArrayList<Integer>> adj , int node , boolean visited[] ,boolean dfsVisited[]){
//         visited[node] = true;
//         dfsVisited[node] = true;
        
//         for(int neighbor : adj.get(node)){
//             if(!visited[neighbor]){
//                 if(isCyclicDFS(adj , neighbor , visited , dfsVisited)){
//                     return true;
//                 }
//             }else if(dfsVisited[neighbor]){
//                 return true;
//             }
//         }
//         dfsVisited[node]= false;
//         return false;
//     }
//     // Function to detect cycle in a directed graph.
//     public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
//         // code here
//         boolean visited[] = new boolean[V];
//         boolean dfsVisited [] = new boolean[V];
        
//         for(int i=0;i<V;i++){
//             if(!visited[i]){
//                 if(isCyclicDFS(adj, i , visited , dfsVisited )){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }


// ************************ Detecting Cycle using BFS **************************

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        // code here
        Queue<Integer> q = new ArrayDeque<>();
        int inDegree[] = new int [N];
        
        // calculate in Degree 
        
        for(int u=0;u<N;u++){
            for(int v:adj.get(u)){
                inDegree[v]++;
            }
        }
        
        for(int i=0;i<N;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        
        int countNode =q.size();
        while(q.size()>0){
            int u = q.remove();
            for(int v:adj.get(u)){
                inDegree[v]--;
                if(inDegree[v]==0){
                    q.add(v);
                    countNode +=1;
                }
            }
        }
        
        if(countNode == N){
            return false;
        }
        
        return true;
    }
}


