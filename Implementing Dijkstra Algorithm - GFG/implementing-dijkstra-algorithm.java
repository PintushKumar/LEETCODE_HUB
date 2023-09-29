//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// class Pair
// {
//     int node;
//     int weight;
//     Pair(int node ,int weight)
//     {
//         this.node=node;
//         this.weight=weight;
//     }
// }

// class Solution
// {
//     static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adjency, int S)
//     {
//         // Write your code here
//         // Queue<Pair>pq=new PriorityQueue<>((a,b)->{
//         //     return a.weight - b.weight;
//         // });
//         Queue<Pair> pq = new PriorityQueue<>((a, b) -> b.weight - a.weight);
//         pq.add(new Pair(S,0));
//         int ans[]=new int[V];
//         Arrays.fill(ans,Integer.MAX_VALUE);
//         ans[S]=0;
//         while(!pq.isEmpty())
//         {
//             Pair currNode =pq.remove();
//             int u= currNode.node;

//             for(ArrayList<ArrayList<Integer>> adj:adjency )
//             {
//                 int v = adj.get(0).get(0);
//                 int wt = adj.get(0).get(1);
                
//                 if(ans[u]+wt < ans[v]){
//                     ans[v]=ans[u]+wt;
//                     pq.add(new Pair(v , ans[v]));
//                 }
//             }
//         }
//         return ans;
//     }
// }

// class Solution
// {
//     static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
//     {
//         Queue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
//         pq.add(new Pair(S, 0));
//         int[] ans = new int[V];
//         Arrays.fill(ans, Integer.MAX_VALUE);
//         ans[S] = 0;

//         while (!pq.isEmpty())
//         {
//             Pair currNode = pq.poll();
//             int u = currNode.node;

//             // for (Pair neighbor : adj.get(u))
//             // {
//             //     int v = neighbor.node;
//             //     int wt = neighbor.weight;

//             //     if (ans[u] + wt < ans[v])
//             //     {
//             //         ans[v] = ans[u] + wt;
//             //         pq.add(new Pair(v, ans[v]));
//             //     }
//             // }
            
//              for(ArrayList<Integer> adj:adjency.get(u) )
//             {
//                 int v = adj.get(0).get(0);
//                 int wt = adj.get(0).get(1);
                
//                 if(ans[u]+wt < ans[v]){
//                     ans[v]=ans[u]+wt;
//                     pq.add(new Pair(v , ans[v]));
//                 }
//             }
//         }
        
//         // int res[] = new int [ans.size()];
//         // for(int i=0;i<ans.size();i++){
//         //     res[i]=ans.get(i);
//         // }
//         // return res;
//         return ans;
//     }
// }



class Pair
{
    int node;
    int weight;
    Pair(int node, int weight)
    {
        this.node = node;
        this.weight = weight;
    }
}

class Solution
{
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>> > adj, int S)
    {
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Pair(S, 0));
        int ans[] = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[S] = 0;
        
        while(!pq.isEmpty())
        {
            Pair currNode = pq.poll();
            int u = currNode.node;
            
            for (ArrayList<Integer> neighbor : adj.get(u))
            {
                int v = neighbor.get(0);
                int wt = neighbor.get(1);
                
                if (ans[u] + wt < ans[v])
                {
                    ans[v] = ans[u] + wt;
                    pq.add(new Pair(v, ans[v]));
                }
            }
        }
        
        return ans;
    }
}

