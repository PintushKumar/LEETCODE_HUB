class Solution {
    public void convert(char[][] board , int n , int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='B'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    public boolean isValid(int i , int j , int n , int m , char [][] board){
        if(i-1 >=0 && i<n && j-1>=0 && j+1<m && board[i][j]=='O'){
            return true;
        }
        return false;
    }
    public void dfs(char[][]board , int i , int j , int n , int m){
        // mark
        board[i][j]='B';
        // visit
        if(isValid(i+1 , j , n , m , board)){
            dfs(board , i+1 , j , n , m);
        }
        if(isValid(i-1 , j , n , m , board)){
            dfs(board , i-1 , j , n , m);
        }
        if(isValid(i , j+1 , n , m , board)){
            dfs(board , i , j+1 , n , m);
        }
        if(isValid(i , j-1 , n , m , board)){
            dfs(board , i, j-1 , n , m);
        }

    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i =0;i<n;i++){
            int j=0;
            if(board[i][j]=='O'){
                dfs(board , i , j , n , m);
            }
            j=m-1;
            if(board[i][j]=='O'){
                dfs(board , i , j , n , m);
            }
        }
        for(int j =0;j<m;j++){
            int i=0;
            if(board[i][j]=='O'){
                dfs(board , i , j , n , m);
            }
            i=n-1;
            if(board[i][j]=='O'){
                dfs(board , i , j , n , m);
            }
        }
        convert(board , n , m);
    }
}