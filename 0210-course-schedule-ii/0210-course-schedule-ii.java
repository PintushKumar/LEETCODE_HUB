class Solution {
    public void dfs(ArrayList<ArrayList<Integer>>adj , int node , boolean [] visited , boolean []dfsVisited , Stack<Integer> st , boolean isCycle[]){
        visited[node]=true;
        dfsVisited[node]=true;
        for(int v:adj.get(node)){
            if(dfsVisited[v]==true){
                isCycle[0]=true;
                return;
            }
            if(!visited[v]){
                dfs(adj , v , visited , dfsVisited , st , isCycle);
            }
        }
        dfsVisited[node]=false;
        st.push(node);
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int crs[]:prerequisites){
            int a = crs[0];
            int b = crs[1];
            adj.get(b).add(a);
        }
        
        boolean visited[] = new boolean[numCourses];
        boolean dfsVisited[] = new boolean[numCourses];
        boolean isCycle[] = new boolean[1];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(isCycle[0]==true){
                    return new int[0];
                }
                dfs(adj , i , visited , dfsVisited , st , isCycle);
            }
        }
        if(isCycle[0]==true){
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