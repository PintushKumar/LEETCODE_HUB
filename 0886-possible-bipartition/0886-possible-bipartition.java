class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>>adj  ,int node , int colors[] , int currColor){
        colors[node]=currColor;
        for(int nbr :adj.get(node)){
            if(colors[nbr]== colors[node]){
                return false;
            }else if(colors[nbr]==-1){
                int newColor = 1-currColor;
                if(!dfs(adj ,nbr , colors ,newColor  )){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int dis[]:dislikes){
            int u = dis[0];
            int v = dis[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int colors[] = new int [n+1];
        Arrays.fill(colors , -1);
        for(int i =0;i<n; i++){
            if(colors[i]==-1){
                if(!dfs(adj ,i , colors , 1)){
                    return false;
                }
            }
        }
        return true;
    }
}