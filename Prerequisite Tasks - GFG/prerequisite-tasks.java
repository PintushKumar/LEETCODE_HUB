//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,P,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isCyclicDFS(ArrayList<ArrayList<Integer>>adj , int node , boolean [] visited , boolean []dfsVisited){
        visited[node]=true;
        dfsVisited[node]=true;
        for(int v:adj.get(node)){
            if(!visited[v]){
                if(isCyclicDFS(adj , v , visited , dfsVisited)){
                    return true;
                }
            }else if(dfsVisited[v]==true){
                return true;
            }
        }
        dfsVisited[node]=false;
        return false;
    }
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int [] course:prerequisites){
            int a = course[0];
            int b = course[1];
            adj.get(b).add(a);
        }
        
        boolean visited[] = new boolean[N];
        boolean dfsVisited[]= new boolean[N];
        
        for(int i=0;i<N;i++){
            if(!visited[i]){
                if(isCyclicDFS(adj , i , visited , dfsVisited)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
}