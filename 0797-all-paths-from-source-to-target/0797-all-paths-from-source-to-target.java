class Solution {
    public void dfs(int graph[][] , int source , int destination , List<Integer> path  , List<List<Integer>> res){
        path.add(source);
        if(source == destination){
            res.add(new ArrayList<>(path)); // Create a copy of path and add it to res
            return;
        } else {
            for(int v: graph[source]){
                dfs(graph , v , destination , path , res);
                path.remove(path.size() - 1); // Remove the last element when backtracking
            }
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int source = 0;
        int destination = graph.length - 1;
        dfs(graph , source , destination , path , res);
        return res;
    }
}
