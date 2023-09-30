//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minRemoval(n, a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java


class Solution {
    static int minRemoval(int N, int intervals[][]) {
        // Sort the intervals by their starting points
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int nonOverlappingInterval = 0;
        int prevEnd = Integer.MIN_VALUE; // Initialize prevEnd to a very small value
        
        for (int i = 0; i < N; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            
            if (prevEnd <= currStart) {
                nonOverlappingInterval++;
                prevEnd = currEnd;
            } else {
                // Adjust prevEnd to the minimum value to ensure the next interval doesn't overlap.
                prevEnd = Math.min(prevEnd, currEnd);
            }
        }
        
        return N - nonOverlappingInterval;
    }
}
