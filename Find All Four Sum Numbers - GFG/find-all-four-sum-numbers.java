//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
        // code here
         ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	   Arrays.sort(nums);
	   int n = nums.length;
	   int i=0;
	   while(i<n){
		   int j = i+1;
		   while(j<n){
			   int l = j+1;
			   int r = n-1;
			   while(l<r){
				   if(nums[i]+nums[j]+nums[l]+nums[r]== target){
					   ArrayList<Integer> ans = new ArrayList<>();
					   ans.add(nums[i]);
					   ans.add(nums[j]);
					   ans.add(nums[l]);
					   ans.add(nums[r]);
					   res.add(ans);
					   int prevL = nums[l];
					   while(l<r && nums[l]== prevL) l++;
					   int prevR = nums[r];
					   while(r>l && nums[r]== prevR)  r--;
				   } else if(nums[i]+nums[j]+nums[l]+nums[r] < target){
					   int prevL = nums[l];
					   while(l<r && nums[l]== prevL) l++;
				   }else{
					   int prevR = nums[r];
					   while(r>l && nums[r]== prevR)  r--;
				   }
			   }
			   int prevJ = nums[j];
			   while(j<n && nums[j]== prevJ)  j++;
		   }
		   int prevI = nums[i];
		   while(i<n && nums[i]== prevI)  i++;
	   }
	   return res;
    }
}