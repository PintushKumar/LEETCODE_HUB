class Solution {
    public void dfs(char board[][] , int i , int j , int n , int m){
        if(i<0 || i>=n || j<0 || j>=m || board[i][j]=='.'){
            return;
        }
        board[i][j]='.';
         dfs(board , i-1 , j , n, m);
         dfs(board , i+1 , j , n, m);
         dfs(board , i , j-1 , n, m);
         dfs(board , i , j+1 , n, m);
    }
    public int countBattleships(char[][] board) {
        int count =0;
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j =0 ; j<m; j++){
                if(board[i][j]== 'X'){
                    count++;
                    dfs(board , i , j , n, m);
                     dfs(board , i , j , n, m);
                     dfs(board , i , j , n, m);
                     dfs(board , i , j , n, m);
                }
            }
        }
        return count;
    }
}