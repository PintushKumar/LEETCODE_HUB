//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int node;
    int weight;
    Pair(int node , int weight){
        this.node = node;
        this.weight = weight;
    }
}
class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int edgewt = edge[2];
            adj.get(u).add(new Pair(v , edgewt));
            adj.get(v).add(new Pair(u , edgewt));
        }
        
        Queue<Pair> pq = new PriorityQueue<>((a , b)->{
            return a.weight - b.weight;
        });
        int dist[] = new int  [n+1];
        int parent[] = new int [n+1];
        Arrays.fill(dist , Integer.MAX_VALUE);
        // for(int i=1;i<=n;i++){
        //     dist[i]=Integer.MAX_VALUE;
        //     parent[i]=i;
        // }
        pq.add(new Pair(1 , 0 ));
        dist[1] =0;
        while(pq.size()>0){
            Pair temp = pq.poll();
            int currNode = temp.node;
            for(Pair nbr : adj.get(currNode)){
                int nbrNode = nbr.node;
                int nbrWeight = nbr.weight;
                if(dist[currNode]+nbrWeight < dist[nbrNode]){
                    dist[nbrNode] = dist[currNode]+nbrWeight;
                    parent[nbrNode] = currNode;
                    pq.add(new Pair(nbrNode , dist[nbrNode]));
                }
            }
        }
        
        ArrayList<Integer> path = new ArrayList<>();
        if(dist[n]==Integer.MAX_VALUE){
            path.add(-1);
            return path;
        }
        
        int node = n;
        
        while(node != 0){
            path.add(node);
            node = parent[node];
        }
        
        Collections.reverse(path);
        
        return path;
        
    }
}

