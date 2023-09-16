class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>>adj , int source , int  destination , boolean visited[]){
        if(source == destination){
            return true;
        }
        if(visited[source] == true){
            return false;
        }
        
        visited[source] = true;
        
        for(int neighbor: adj.get(source)){
            if(dfs(adj , neighbor, destination , visited)==true){
                return true;
            }  
        }
        
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
      //  int n = edges.length;
        boolean visited[] = new boolean [ n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        // for(int i=0;i<n;i++){
        //     if(!visited[i]){
                if(dfs(adj ,  source , destination , visited)==false){
                    return false;
                }
        //     }
        // }
        return true;
    }
}