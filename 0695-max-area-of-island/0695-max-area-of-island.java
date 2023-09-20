class Solution {
    public int dfs(int grid[][] , int i , int j , int n , int m){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]==0){
            return 0;
        }
        
        int count = 1;
        grid[i][j] =0;
        
        count+= dfs(grid , i-1 , j , n , m );
        count+= dfs(grid , i+1 , j , n , m );
        count+= dfs(grid , i , j-1 , n , m );
        count+= dfs(grid , i , j+1 , n , m );
        
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(i*j ==0 || i==n-1 || j==m-1){
        //             dfs(grid , i , j , n , m );
        //         }
        //     }
        // }
        
        int maxArea = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                  maxArea = Math.max(maxArea , dfs(grid , i , j , n , m ));
                }
            }
        }
        
        return maxArea;
    }
}