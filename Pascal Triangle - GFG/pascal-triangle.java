//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        // code here
        ArrayList<Long> ans = new ArrayList<>();
        
        List<List<Long>> triangle = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Long> triangleRow = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i ){
                    triangleRow.add(1l);
                }else{
                    long aboveTwoSum = (triangle.get(i-1).get(j)+triangle.get(i-1).get(j-1))%1000000007;
                    triangleRow.add(aboveTwoSum);
                }
            }
            triangle.add(triangleRow);
        }
        
        int size = triangle.size();
        List<Long> row = triangle.get(size-1);
        ans.addAll(row);
        
        return ans;
    }
}