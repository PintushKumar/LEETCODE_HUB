// *********************** DFS ************************************

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


// *********************** BFS **************************************

// class Solution {
//     public List<Integer> eventualSafeNodes(int[][] graph) {
//         int V = graph.length;
//         List<List<Integer>> adj = new ArrayList<>();
//         for(int i=0;i<V;i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int u=0;u<V;u++){
//             for(int v : graph[u]){
//                 adj.get(v).add(u);
//             }
//         }
        
//         int inDegree[] = new int [V];
//         for(int i=0;i<V;i++){
//             for(int v : adj.get(i)){
//                 inDegree[v]++;
//             }
//         }
        
//         Queue<Integer> q = new ArrayDeque<>();
        
//         for(int i=0;i<V;i++){
//             if(inDegree[i]==0){
//                 q.add(i);
//             }
//         }
        
//         boolean safe [] = new boolean[V];
        
//         while(q.size()>0){
//             int currNode = q.remove();
//             safe[currNode] = true;
//             for(int v : adj.get(currNode)){
//                 inDegree[v]--;
//                 if(inDegree[v]==0){
//                     q.add(v);
//                 }
//             }
//         }
        
//         List<Integer> resSafe = new ArrayList<>();
        
//         for(int i=0;i<V;i++){
//             if(safe[i]== true)
//                 resSafe.add(i);
//         }
//         return resSafe;
//     }
// }
