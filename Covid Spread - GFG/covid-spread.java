//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        while(t-- > 0)
        {
            
            
            int R = sc.nextInt();
            
            int C = sc.nextInt();
            
           
            
            int hospital[][] = new int[R][C];
            
            int cnt=0;
            for(int i = 0; i < R; i++)
                {
                    for(int j=0; j < C; j++)
                {
                    hospital[i][j] = sc.nextInt();
                }
                    
                }
            
            Solution ob = new Solution();
            System.out.println(ob.helpaterp(hospital));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Pair{
    int row ;
    int col;
    Pair(int row , int col){
        this.row = row;
        this.col = col;
    }
}

class Solution{
    public int helpaterp(int[][] hospital) {
        // code here
        int n = hospital.length;
        int m = hospital[0].length;
        Queue<Pair> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(hospital[i][j]==2){
                    hospital[i][j]=0;
                    q.add(new Pair(i , j));
                }
            }
        }
        int dr[]={-1 , 1 , 0 , 0};
        int dc []={0, 0 , -1 , 1};
        int time =0;
        while(q.size()>0){
            int size= q.size();
            while(size-->0){
                Pair temp = q.remove();
                int row = temp.row;
                int col = temp.col;
                for(int i=0;i<4;i++){
                    int nrow = row+dr[i];
                    int ncol = col+dc[i];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && hospital[nrow][ncol]==1){
                        hospital[nrow][ncol]=0;
                        q.add(new Pair(nrow , ncol));
                    }
                }
                
            }
            time++;
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(hospital[i][j]==1){
                    return -1;
                }
            }
        }
        return time-1;
        
    }
}
