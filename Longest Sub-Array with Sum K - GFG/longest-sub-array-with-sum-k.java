//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    
   
    // Function for finding maximum and value pair
    // public static int lenOfLongSubarr (int A[], int N, int K) {
    //     //Complete the function
    //     HashMap<Integer , Integer> map = new HashMap<>();
    //     int longestSubarray =0  , sum=0;
    //     map.put(0 , -1);
    //     for(int i=0;i<N;i++){
    //         sum+=A[i];
    //         int x = ((sum % K) + K) % K;
    //         if(map.containsKey(x)){
    //             longestSubarray = Math.max(longestSubarray , i-map.get(x));
    //         }else{
    //             map.put(x , i);
    //         }
    //     }
    //     return longestSubarray;
    // }
public static int lenOfLongSubarr(int A[], int N, int K) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int longestSubarray = 0, sum = 0;

    map.put(0, -1);

    for (int i = 0; i < N; i++) {
        sum += A[i];

        if (map.containsKey(sum - K)) {
            longestSubarray = Math.max(longestSubarray, i - map.get(sum - K));
        }

        if (!map.containsKey(sum)) {
            map.put(sum, i);
        }
    }

    return longestSubarray;
}


    
    
}


