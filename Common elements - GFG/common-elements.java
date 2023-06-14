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
        // ArrayList<Integer> res = new ArrayList<Integer>();
        // int i=0,j=0,k=0;
        // while(i<n1 && j<n2 && k<n3){
        //     if(A[i]==B[j]&& B[j]==C[k]){
        //         res.add(A[i]);
        //         i++;
        //         j++;
        //         k++;
        //     }
        //   else if(A[i]<B[j]){
        //         i++;
        //     }
        //     else if(B[j]<C[k]){
        //         j++;
        //     }
        //     else{
        //         k++;
        //     }
        //     int x = A[i-1];
        //     while(A[i-1]==x){
        //         i++;
        //     }
        //      int y = B[i-1];
        //     while(B[i-1]==x){
        //         j++;
        //     }
        //      int z = C[i-1];
        //     while(C[i-1]==z){
        //         k++;
        //     }
        // }
        // if(res.size()==0){
        //     res.add(-1);
        //     return res;
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