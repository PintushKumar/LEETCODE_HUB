//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;
class Driverclass
 {
	public static void main (String[] args) {
	   
	   Scanner in = new Scanner(System.in);
	   int t= in.nextInt();
	   while(t-->0){
	       
	       int n = in.nextInt();
	       int [] arr= new int[n];
	       for(int i=0;i<n;i++) {
	           arr[i] = in.nextInt();
	       }
	       System.out.println(new Solution().countSubarrWithEqualZeroAndOne(arr, n));
	   }
	 }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        // add your code here
        int sum =0;
        HashMap<Integer , Integer > map = new HashMap<>();
        int count =0;
        for(int ele : arr){
            
            if(ele ==0){
                sum -= 1;
            }else{
                sum+=ele;
            }
            
            
            if(sum ==0){
                count++;
            }
            
            
            if(map.containsKey(sum)){
                count+=map.get(sum);
                map.put(sum , map.get(sum)+1);
            }else{
                map.put(sum , map.getOrDefault(sum, 0)+1);
            }
        }
        return count;
    }
}


