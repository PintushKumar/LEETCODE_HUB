//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        int n = arr.length;
        int maxPossibleValue = 100000; // Adjust this value based on your problem constraints
        int ans[] = new int[maxPossibleValue + 1]; // Make sure the ans array is large enough
        Arrays.fill(ans, -1);
        int mod = 100000;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start % mod);
        ans[start % mod] = 0; // Initialize the starting point
        while (!q.isEmpty()) {
            int temp = q.remove();
            if (temp == end) return ans[end];
            for (int i = 0; i < n; i++) {
                int toPush = (temp % mod * arr[i] % mod) % mod;
                if (ans[toPush] == -1) {
                    ans[toPush] = ans[temp] + 1;
                    q.add(toPush);
                }
            }
        }
        return -1;
    }
}

