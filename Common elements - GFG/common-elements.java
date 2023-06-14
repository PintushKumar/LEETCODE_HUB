//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            
            int A[] = new int[n1];
            int B[] = new int[n2];
            int C[] = new int[n3];
            
            for (int i = 0;i < n1;i++)
            {
                A[i] = sc.nextInt();
            }
            for (int i = 0;i < n2;i++)
            {
                B[i] = sc.nextInt();
            }
            for (int i = 0;i < n3;i++)
            {
                C[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            ArrayList<Integer> res = sol.commonElements(A, B, C, n1, n2, n3);
            if (res.size() == 0)
            {
                System.out.print(-1);
            }
            else 
            {
                for (int i = 0;i < res.size();i++)
                {
                    System.out.print(res.get(i) + " ");
                }    
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        // code here 
        // ArrayList<Integer>res = new ArrayList<>();
        // // Initialize starting indexes for ar1[], ar2[] and
        // // ar3[]
        // int i = 0, j = 0, k = 0;
    
        // // Iterate through three arrays while all arrays have
        // // elements
        // while (i < n1 && j < n2 && k < n3) {
        //     // If x = y and y = z, print any of them and move
        //     // ahead in all arrays
        //     if (A[i] == B[j] && B[j] == C[k]) {
        //         if(!res.contains(A[i])){
        //             res.add(A[i]);
        //         }
        //         i++;
        //         j++;
        //         k++;
        //     }
    
        //     // x < y
        //     else if (A[i] < B[j])
        //         i++;
    
        //     // y < z
        //     else if (B[j] < C[k])
        //         j++;
    
        //     // We reach here when x > y and z < y, i.e., z is
        //     // smallest
        //     else
        //         k++;
        // }
        // return res;
        
        ArrayList<Integer>res = new ArrayList<>();
        HashSet<Integer>a = new HashSet<>();
        HashSet<Integer>b = new HashSet<>();
        HashSet<Integer>c = new HashSet<>();
        for(Integer ele:A){
            a.add(ele);
        }
        for(Integer ele:B){
            b.add(ele);
        }
        for(Integer ele:C){
            c.add(ele);
        }
        HashSet<Integer>temp = new HashSet<>();
        for(Integer ele:B){
            if(a.contains(ele)){
                temp.add(ele);
            }
        }
        
        for(Integer ele:C){
            if(temp.contains(ele) && !res.contains(ele)){
                res.add(ele);
            }
        }
        return res;
    }
}
