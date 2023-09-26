class Pair{
    int row;
    int col;
    int dist ;
    Pair(int row , int col , int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int dist[][] = new int [n][m];
        boolean visited[][] = new boolean[n][m];
        Queue<Pair> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i , j , 0));
                    dist[i][j]=0;
                    visited[i][j]=true;
                }
            }
        }
        int dr[] = {-1 , 1 , 0 , 0 };
        int dc[]={0 , 0 , -1 , 1};
        while(q.size()>0){
            Pair temp = q.remove();
            int row = temp.row;
            int col = temp.col;
            int distance = temp.dist;
            dist[row][col]=distance;
            for(int i=0;i<4;i++){
                int nrow = row+dr[i];
                int ncol = col+dc[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&  visited[nrow][ncol]==false){
                    visited[nrow][ncol]=true;
                    q.add(new Pair(nrow , ncol , distance+1));
                }
            }
        }
        return dist;
    }
}