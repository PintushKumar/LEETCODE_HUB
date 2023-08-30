//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
   	public static int [] nseleOLIndxs(long []arr , int n ){
		// Stack:: people looking for next samller elemnt on left
		Stack<Integer> st = new Stack<>();
		int nseli [] = new int [n];
		for(int i= n-1;i>=0;i--){
			long ele = arr[i];
			while(st.size()>0 && ele<arr[st.peek()]){
				int ind = st.pop();
				nseli[ind]=i;
			}
			st.push(i);
		}
		while(st.size()>0){
			int ind = st.pop();
			nseli[ind]=-1;
		}
		return nseli;
	}
	public static int [] nseleORIndxs(long []arr , int n ){
		// Stack:: people looking for next samller elemnt on left
		Stack<Integer> st = new Stack<>();
		int nseri [] = new int [n];
		for(int i=0;i<n;i++){
			long ele = arr[i];
			while(st.size()>0 && ele < arr[st.peek()]){
				int ind = st.pop();
				nseri[ind]=i;
			}
			st.push(i);
		}
		while(st.size()>0){
			int ind = st.pop();
			nseri[ind]=n;
		}
		return nseri;
	}
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        int [] nseleOLIndx = nseleOLIndxs(hist ,(int) n);
        int [] nseleORIndx = nseleORIndxs(hist ,(int) n);
        long mxArea = Long.MIN_VALUE;
        for(int i=0;i<n;i++){
            long h = hist[i];
            long w = nseleORIndx[i]-nseleOLIndx[i]-1;
            long area = h*w;
            mxArea = Math.max(mxArea , area);
        }
        return mxArea;
    }
        
}



