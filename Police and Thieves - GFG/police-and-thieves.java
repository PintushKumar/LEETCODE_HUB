//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 


// } Driver Code Ends
//User function Template for Java

class Solution 
{ 
    static int catchThieves(char arr[], int n, int k) 
	{ 
        // Code here
        ArrayList<Integer> pol = new ArrayList<>();
        ArrayList<Integer> thf = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i]=='P')
                pol.add(i);
            else
                thf.add(i);
        }
        int pl =0 , th =0 , catches =0;
        while(pl<pol.size()&& th<thf.size()){
            if(Math.abs(pol.get(pl)-thf.get(th))<=k){
                catches++;
                pl++;
                th++;
            }else if(pol.get(pl)-thf.get(th)>k){
                th++;
            }else{
                pl++;
            }
        }
        return catches;
	} 
} 



//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
			char arr[] = new char[n];
			for(int i=0; i<n; i++)
         		arr[i] = sc.next().charAt(0);

			Solution ob = new Solution();
            System.out.println(ob.catchThieves(arr, n, k));
            t--;
        }
    }
}       
// } Driver Code Ends