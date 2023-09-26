//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            String[] dictionary = new String[N];
            for(int i=0;i<N;i++)
            {
                dictionary[i] = sc.next();
            }
            
            int R = Integer.parseInt(sc.next());
            int C = Integer.parseInt(sc.next());
            
            char board[][] = new char[R][C];
            for(int i=0;i<R;i++)
            {
                for(int j=0;j<C;j++)
                {
                    board[i][j] = sc.next().charAt(0);
                }
            }
            
            Solution obj = new Solution();
            String[] ans = obj.wordBoggle(board, dictionary);
            
            if(ans.length == 0) System.out.println("-1");
            else
            {
                Arrays.sort(ans);
                for(int i=0;i<ans.length;i++)
                {
                    System.out.print(ans[i] + " ");
                }
                System.out.println();
            }
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean dfs(char board[][] , int i , int j , int n , int m , String word , int indx){
        if(indx == word.length()){
            return true;
        }
        if(i<0 || i>=n || j<0 || j>=m || board[i][j] != word.charAt(indx)){
            return false;
        }
        char ch = board[i][j];
        board[i][j]='*';
        boolean up1 = dfs(board , i+1 , j , n , m , word , indx+1 );
        boolean up2 = dfs(board , i-1 , j , n , m , word , indx+1 );
        boolean up3 = dfs(board , i , j+1 , n , m , word , indx+1 );
        boolean up4 = dfs(board , i , j-1 , n , m , word , indx+1 );
        boolean up5 = dfs(board , i+1 , j+1 , n , m , word , indx+1 );
        boolean up6 = dfs(board , i-1 , j-1 , n , m , word , indx+1 );
        boolean up7 = dfs(board , i+1, j-1 , n , m , word , indx+1 );
        boolean up8 = dfs(board , i-1 , j+1 , n , m , word , indx+1 );
        board[i][j]=ch;
        return up1||up2||up3||up4||up5||up6||up7||up8;
    }
    public String[] wordBoggle(char board[][], String[] dictionary)
    {
        // Write your code here
        ArrayList<String> res = new ArrayList<>();
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<dictionary.length;i++){
            String s = dictionary[i];
            for(int k=0;k<n;k++){
                for(int j=0;j<m;j++){
                    if(board[k][j]==s.charAt(0)){
                        if(dfs(board , k , j, n , m , s , 0)){
                            if(!res.contains(s)){
                                res.add(s);
                            }
                        }
                    }
                }
            }
        }
        
        String finalRes [] = new String[res.size()];
        for(int i=0;i<res.size();i++){
            finalRes[i]=res.get(i);
        }
        return finalRes;
    }
}