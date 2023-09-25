//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Gfg {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int m=Integer.parseInt(s[1]);
            char c[][]=new char[n][m];
            for(int i=0;i<n;i++){
                s=in.readLine().trim().split(" ");
                for(int j=0;j<m;j++){
                    c[i][j]=s[j].charAt(0);
                }
            }
            Solution ob=new Solution();
            int ans[][]=ob.chefAndWells(n, m, c);

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    out.print(ans[i][j]+" ");
                }
                out.println();
            }
        }
        out.close();
    }
}
// } Driver Code Ends

class Pair{
    int row;
    int col;
    Pair(int row , int col){
        this.row = row;
        this.col = col;
    }
}

//User function Template for Java
class Solution
{
    public int[][] chefAndWells(int n,int m,char grid [][])
    {
        int res[][] = new int [n][m];
        Queue<Pair> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='W'){
                    q.add(new Pair(i , j));
                    res[i][j]=0;
                }else{
                    res[i][j]=-1;
                }
            }
        }
        
        int dr[] = {-1 , 1 , 0 , 0};
        int dc [] = {0 , 0 , -1 , 1};
        
        while(q.size()>0){
            Pair temp = q.remove();
            int row = temp.row;
            int col = temp.col;
            for(int i=0;i<4;i++){
                int nrow = row + dr[i];
                int ncol = col + dc[i];
                if(nrow>=0 && nrow <n && ncol>=0 && ncol<m && grid[nrow][ncol] != 'N' && res[nrow][ncol]==-1){
                    res[nrow][ncol] =  res[row][col] + 1;
                    q.add(new Pair(nrow , ncol));
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='N'||grid[i][j]=='.'){
                    res[i][j]=0;
                }else if(res[i][j] !=-1){
                    res[i][j] *=2;
                }
            }
        }
        
        return res;
    }
}

