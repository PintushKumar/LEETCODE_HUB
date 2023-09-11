//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);

            for (int i = 0; i < n; i++)
                list.add(i, new ArrayList<Integer>());

            ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
            for (int i = 1; i <= m; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(v).add(u);
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(u);
                pair.add(v);
                prerequisites.add(pair);
            }

            int[] res = new Solution().findOrder(n, m, prerequisites);
            
            if(res.length==0)
                System.out.println("No Ordering Possible");
            else
            {
                if (check(list, n, res) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static void dfs(ArrayList<ArrayList<Integer>> adj , int u , boolean visited[] , boolean dfsVisited[] , boolean isCycle[] , Stack<Integer> st){
        visited[u]=true;
        dfsVisited[u]=true;
        for(int v:adj.get(u)){
            if(dfsVisited[v]){
                isCycle[0]=true;
                return;
            }
            if(!visited[v]){
                dfs(adj , v , visited , dfsVisited , isCycle , st);
            }
        }
        
        st.push(u);
        dfsVisited[u]=false;
    }
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        // add your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(ArrayList<Integer> crs:prerequisites){
            int a = crs.get(0);
            int b = crs.get(1);
           // b--->a;
           adj.get(b).add(a);
        }
        
        Stack<Integer> st = new Stack<>();
        boolean isCycle[] = new boolean[1];
        boolean visited[] = new boolean[n];
        boolean dfsVisited[] = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(adj , i , visited , dfsVisited , isCycle , st);
            }
        }
        
        if(isCycle[0]){
            return new int[0];
        }
        
        int res[] = new int[st.size()];
        
        int i=0;
        while(st.size()>0){
            res[i++]=st.pop();
        }
        return res;
    }
}