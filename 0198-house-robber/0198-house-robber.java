// class Solution {
//     public int helper(int nums[] , int i , int n , int dp[]){
//         if(i>=n){
//             return 0;
//         }
//         if(dp[i]!=-1){
//             return dp[i];
//         }
//         int steal = nums[i]+helper(nums , i+2, n , dp);
//         int skipp = helper(nums , i+1 , n , dp);
//         dp[i]= Math.max(steal , skipp);
//         return dp[i];
//     }
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int dp[] = new int [n];
//         Arrays.fill(dp , -1);
//         int res = helper(nums , 0 , n , dp);
//         return res;
//     }
// }

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int [n+1];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=2;i<=n;i++){
            int steal = nums[i-1]+dp[i-2];
            int skip = dp[i-1];
            dp[i]= Math.max(steal , skip);
        }
        return dp[n];
    }
}

// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if(n==0){
//             return 0;
//         }
//         if(n==1){
//             return nums[0];
//         }
//         int prevMax = nums[0];
//         int currMax = Math.max(nums[1] , prevMax);
//         for (int i = 2; i <n; i++) {  // Iterate until i <= n
//            int temp = currMax ;
//             currMax = Math.max(currMax , nums[i]+prevMax);
//             prevMax = temp;
//         }
//         return currMax;
//     }
// }

    