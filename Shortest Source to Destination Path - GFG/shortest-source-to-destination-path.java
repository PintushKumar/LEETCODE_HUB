//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair{
    int row ;
    int col ;
    int dist ;
    
    Pair(int row , int col , int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0 , 0 , 0));
        while(q.size()>0){
            Pair temp = q.remove();
            int row = temp.row;
            int col = temp.col;
            int dist = temp.dist;
            if(row>=0 && row<N && col>=0 && col <M && A[row][col] !=0){
                if(row == X && col == Y){
                    return dist;
                }
                A[row][col] = 0;
                q.add(new Pair(row+1 , col , dist+1));
                q.add(new Pair(row-1 , col , dist+1));
                q.add(new Pair(row , col+1 , dist+1));
                q.add(new Pair(row , col-1 , dist+1));
            }
        }
        return -1;
    }
};