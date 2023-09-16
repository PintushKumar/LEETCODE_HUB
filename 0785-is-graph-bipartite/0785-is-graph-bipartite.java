class Solution {

    // *********************************** DFS ***********************************8
    public boolean dfs(int [][] graph , int curr , int colors[] , int currColor){
        colors[curr] = currColor;
        for(int neighbor : graph[curr]){
            if(colors[neighbor]== colors[curr]){
                return false;
            }else if(colors[neighbor]==-1){
                int neighborColor = 1 - currColor; // if curr color ( red)  0   then neighbor color 1-0 = 1  then  
                                                   //neighbor color as blue  visa  versa if currColor blue 1  then neighbor 
                                                   // color red 1-1 = 0 (means red)
                if(dfs(graph , neighbor , colors , neighborColor)== false){
                    return false;
                }
            }
        }
        return true;
    }

    // ******************************** BFS ***********************************************

    public boolean bfs(int graph[][] , int curr , int colors[]){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(curr);
        colors[curr] = 1;  // we color current node as blue
        while(q.size()>0){
            int qCurr = q.remove();
            for(int neighbor:graph[qCurr]){
                if(colors[neighbor]== colors[qCurr]){
                    return false;
                }else if(colors[neighbor]== -1){
                    colors[neighbor] = 1 - colors[qCurr];
                    q.add(neighbor);
                }
            }
        }
        return true;
    }

// **************************************** Main Function ******************************

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];			
		Arrays.fill(colors , -1);  // -1 represents not colored 
        // 0 represents red color;
        // 1 represents blue color

        // **************************** DFS ************************************************

        // for (int i = 0; i < n; i++) {              //This graph might be a disconnected graph. So check each unvisited node.
        //     if(colors[i]==-1){
        //         if(dfs(graph , i , colors , 1)==false){
        //             return false;
        //         }
        //     }
        // }
        // return true;

// ************************************** BFS ******************************************************
        for (int i = 0; i < n; i++) {              //This graph might be a disconnected graph. So check each unvisited node.
            if(colors[i]==-1){
                if(bfs(graph , i , colors )==false){
                    return false;
                }
            }
        }
        return true;
    }
    
}