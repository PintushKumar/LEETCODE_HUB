//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X) {
        boolean visited[] = new boolean[V];
        int levels = 0; // Initialize levels to 0.
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            while(size-->0) {
                int currNode = q.poll();
                if (currNode == X) {
                    return levels;
                }
                for (int nbr : adj.get(currNode)) {
                    if (!visited[nbr]) {
                        visited[nbr] = true;
                        q.add(nbr);
                    }
                }
            }
            levels++; // Increase levels after processing the current level.
        }
        return -1;
    }
}
