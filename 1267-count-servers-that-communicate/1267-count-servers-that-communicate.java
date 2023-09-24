// ************************ First Solution ************************


// class Solution {
//     public int countServers(int[][] grid) {
//         if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
//         int n = grid.length;
//         int m = grid[0].length;
//         int res = 0;
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (grid[i][j] == 1) {
//                     int val = dfs(grid, i, j , n , m );
//                     res += val == 1 ? 0 : val;
//                 }
//             }
//         }
//         return res;
//     }
    

//    int dfs(int[][] grid, int i, int j , int n , int m) {
//         grid[i][j] = 0;
//         int res = 1;
//         for (int x = 0; x < n; x++) {
//             if (grid[x][j] == 1) {
//                 res += dfs(grid, x, j , n , m);
//             }
//         }
//         for (int x = 0; x < m; x++) {
//             if (grid[i][x] == 1) {
//                 res += dfs(grid, i, x , n, m);
//             }
//         }
//         return res;
//     }
// }

// ********************* Second Solution ****************************

class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int row[] = new int [n];
        int col [] = new int [m];
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j]==1){
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int connectedServer =0;

        for(int i=0;i<n;i++){
            for(int j =0 ;j<m ;j++){
                if(grid[i][j]==1 && (row[i]>1 || col[j]>1 )){
                    connectedServer++;
                }
            }
        }
        return connectedServer;
    }
}