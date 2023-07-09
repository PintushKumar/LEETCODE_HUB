//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args)throws IOException
	{

// 		Scanner in = new Scanner(System.in);
        
// 		int t = in.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
         //testcases
        int t = Integer.parseInt(read.readLine());
		
		while(t-- >0)
		{
		    //size of array
		    int n = Integer.parseInt(read.readLine());
		    long[] arr= new long[n];
		    
		    String str[] = read.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0;i<n;i++)
		        arr[i] = Long.parseLong(str[i]);
		    
		    // StringBuffer sb = new StringBuffer();
		    
		    Solution ob = new Solution();
		    
		    //calling rearrange() function
		    ob.rearrange(arr, n);
		    StringBuffer sb = new StringBuffer();
		    
		    //appending and printing the elements
		    for(int i =0; i < n; i++)
		     sb.append(arr[i] + " ");
		    System.out.println(sb);
		}
	}
}




// } Driver Code Ends


class Solution{
    
    // temp: input array
    // n: size of array
    //Function to rearrange  the array elements alternately.
    public static void rearrange(long arr[], int n){
        long maxElement = arr[n-1] + 1; // Store a value greater than the maximum value in the array
        int st = 0, end = n - 1;
        
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                // Encoding: Add the modulo value multiplied by maxElement to the current element
                arr[i] += (arr[end] % maxElement) * maxElement; // Example: arr[i] = 1 + (5 % 6) * 6 = 31
                end--;
            } else {
                // Encoding: Add the modulo value multiplied by maxElement to the current element
                arr[i] += (arr[st] % maxElement) * maxElement; // Example: arr[i] = 2 + (2 % 6) * 6 = 14
                st++;
            }
        }
        
        for(int i = 0; i < n; i++){
            // Decoding: Divide the encoded value by maxElement to obtain the rearranged array
            arr[i] /= maxElement; // Example: arr[i] = 31 / 6 = 5
        }
    }
}


