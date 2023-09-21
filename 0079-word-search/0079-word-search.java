class Solution {
    public boolean dfs(char [][]board , int i , int j , int n , int m , String word , int indx){
        if(indx == word.length()){
            return true;
        }
        
        // if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != word.charAt(indx)) {
        //     return false;
        // }
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != word.charAt(indx)){
            return false;
        }
        
        char ch = board[i][j];
        board[i][j] ='*';
         boolean up = dfs(board , i-1 , j , n, m, word , indx+1);
        boolean down = dfs(board , i+1 , j , n, m, word , indx+1);
        boolean left = dfs(board , i , j-1 , n, m, word , indx+1);
        boolean right = dfs(board , i , j+1 , n, m, word , indx+1);
        board[i][j] = ch;
        return up || down || left|| right; 
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0 ; j<m;j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board , i , j , n, m , word,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}