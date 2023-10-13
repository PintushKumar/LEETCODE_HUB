class Solution {
    public int solve(int cost[] , int i , int dp[]){
        if(i>=cost.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        
        int a = cost[i]+solve(cost , i+1 , dp);
        int b = cost[i]+solve(cost , i+2 , dp);
      return  dp[i] = Math.min(a , b);
       // return Math.min(a , b);
    }
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int [1001];
        Arrays.fill(dp , -1);
        return Math.min(solve(cost , 0 , dp) ,solve(cost , 1 , dp));
    }
}