class Solution {
     void destroyDFS(int grid[][] , int i , int j , int  n , int m ){
        if(i<0 || i>= n || j<0 || j>=m || grid[i][j]==0){
            return;
        }
         
        grid[i][j]=0;  // mark
         
        destroyDFS(grid , i-1 , j , n , m); // up
        destroyDFS(grid , i+1 , j , n , m); // down
        destroyDFS(grid , i , j-1 , n , m); // left
        destroyDFS(grid , i , j+1 , n , m); // right
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i*j == 0 || i == n-1 || j == m-1 ){
                    destroyDFS(grid , i , j , n , m );
                }
            }
        }
        
        int enclaves = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    enclaves++;
                }
            }
        }
        
        return enclaves;
        
    }
}