//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

            

class Solution{
    
  
    int Countpair(int arr[], int n, int sum)
    {
        // Complete the function
        int i=0 , j=n-1 , cnt =0;
        while(i<j){
            if(arr[i]+arr[j]==sum){
                cnt++;
                i++;
                j--;
            }else if(arr[i]+arr[j]<sum){
                i++;
            }else{
                j--;
            }
        }
        if(cnt==0){
            return -1;
        }
        return cnt;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    int K = Integer.parseInt(br.readLine());
		    
		    Solution obj = new Solution();
		   
		    int res = obj.Countpair(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		    
		    
		}
	}
}



// } Driver Code Ends