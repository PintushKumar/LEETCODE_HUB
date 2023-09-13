class Solution {
    void dfs(int [][]adj , int node , boolean visited[] , int n){
		visited[node]=true;
		for(int i=0;i<n;i++){
			if(!visited[i] && adj[i][node]==1){
				dfs(adj , i , visited,n);
			}
		}
	}
    public int findCircleNum(int[][] adj) {
        int N = adj.length;
        boolean visited [] = new boolean[N];
		int count =0;
		for(int i=0;i<N;i++){
			if(!visited[i]){
				count++;
				dfs(adj , i , visited , N);
			}
		}
		return count;
    }
}