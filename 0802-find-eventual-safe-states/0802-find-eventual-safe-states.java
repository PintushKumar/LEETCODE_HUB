class Solution {
        public boolean  dfs(int[][] graphs , int currNode , boolean visited[]  , boolean dfsVisited[]){
        visited[currNode]=true;
        dfsVisited[currNode]=true;
        for( int nbr : graphs[currNode]){
            if(!visited[nbr]){
                if( dfs(graphs , nbr , visited , dfsVisited )){
                    return true;
                }
            }else if(dfsVisited[nbr]== true){
                return true;
            }
        }
        dfsVisited[currNode]=false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graphs) {
        int V = graphs.length;
        // List<List<Integer>> adj = new ArrayList<>();
        // for(int i=0;i<V;i++){
        //     adj.add(new ArrayList<>());
        // }
        // for(int graph[] :graphs){
        //     int u = graph[0];
        //     int v = graph[1];
        //     adj.get(u).add(v);
        // }
        boolean visited[] = new boolean [V];
        boolean dfsVisited[] = new boolean [V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(graphs , i , visited , dfsVisited);
            }
        }
        List<Integer> res = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            if(dfsVisited[i]==false){
                res.add(i);
            }
        }
        return res;
    }
}