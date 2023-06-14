//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.HashMap; 
import java.util.Map; 
import java.util.Map.Entry; 


// } Driver Code Ends
//User function Template for Java

class Solution{
    // A1[] : the input array-1
    // N : size of the array A1[]
    // A2[] : the input array-2
    // M : size of the array A2[]
    
    //Function to sort an array according to the other array.
    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M)
    {
        //Your code here
        // Arrays.sort(A1);
        // HashMap<Integer , Integer> hmp = new HashMap<>();
        TreeMap<Integer, Integer> hmp = new TreeMap<>();
        for(Integer ele:A1){
            hmp.put(ele , hmp.getOrDefault(ele , 0)+1);
        }
        
        int res[]=new int[N];
        int indx =0;
        
        for(Integer ele:A2){
            if(hmp.containsKey(ele)){
                while(hmp.get(ele)!=0){
                    res[indx++]=ele;
                    hmp.put(ele , hmp.getOrDefault(ele,0)-1);
                }
            }
        }
       
        for (Map.Entry<Integer, Integer> entry : hmp.entrySet()) {
            int key = entry.getKey();
            int len = entry.getValue();
            if (len <= 0) continue;
            while (len != 0) {
                res[indx++]=key;
                len--;
            }
        }

    
        return res;
        
        // int[] res= new int[N];
        // int resInd = 0;
        
        // TreeMap<Integer, Integer> map = new TreeMap<>();
        // for(int i=0;i<N;i++){
        //     map.put(A1[i] , map.getOrDefault(A1[i],0)+1);
        // }
        
        // for(int i=0;i<M;i++){
        //     if(map.containsKey(A2[i])){
        //         int len = map.get(A2[i]);
        //         while(len-- > 0){
        //             A1[resInd++] = A2[i];
        //         }
        //         map.put(A2[i], 0);
        //     }
                
        // }
      
        // for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     if(entry.getValue()!=0) {
        //         int len = entry.getValue();
        //         int val = entry.getKey();
        //         while(len-- > 0)
        //             A1[resInd++] = val;
        //     }
        // }
       
        // return A1;
    }
}



//{ Driver Code Starts.
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    int a1[]=new int[n];
		    int a2[]=new int[m];
		    
		    for(int i=0;i<n;i++)
		    a1[i]=sc.nextInt();
		    
		    for(int i=0;i<m;i++)
		    a2[i]=sc.nextInt();
		    Solution ob=new Solution();
		    a1 = ob.sortA1ByA2(a1,n,a2,m);
		    for(int x:a1)
		    System.out.print(x+" ");
		    
		    System.out.println();
		}
	}
	

}



// } Driver Code Ends