class Pair{
    int node;
    int weight;
    Pair(int node , int weight){
        this.node = node;
        this.weight = weight;
    }
}
class Solution {
    public void dfs(ArrayList<ArrayList<Pair>>adj , int node ,boolean visited[] ,int min[]){
        visited[node]=true;
        for(Pair nbr : adj.get(node)){
            int nbrNode = nbr.node;
            int nbrwt = nbr.weight;
            min[0] = Math.min(min[0] , nbrwt);
            if(!visited[nbrNode])
                dfs(adj , nbrNode , visited ,min);
        }
    }
    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int rd[] : roads){
            int u = rd[0];
            int v = rd[1];
            int wt =rd[2];
            adj.get(u).add(new Pair(v , wt));
            adj.get(v).add(new Pair(u , wt));
        }
        int min[] ={ Integer.MAX_VALUE};
        boolean visited[] = new boolean [n+1];
        for(int i=0;i<=n;i++){
            if(!visited[i]){
                dfs(adj , 1 , visited , min);
            }
        }
        return min[0];
    }
}