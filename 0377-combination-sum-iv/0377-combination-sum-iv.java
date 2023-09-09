public class Solution {
    private int n;
    private int[][] t;

    public int solve(int idx, int[] nums, int target) {
        if (target == 0)
            return 1;
        if (idx >= n || target < 0)
            return 0;
        if (t[idx][target] != -1)
            return t[idx][target];

// ************  not for lopp ***********
        // int take_idx = solve(0, nums, target - nums[idx]);
        // int reject_idx = solve(idx + 1, nums, target);
        // t[idx][target] = take_idx + reject_idx;
       // return t[idx][target];

// ********************************************
        int result =0;

        for(int i=0;i<nums.length;i++){
            int take_i = solve(0 , nums , target-nums[i]);
            result += take_i;
        }

        t[idx][target]=result;
        return t[idx][target];

    }

    public int combinationSum4(int[] nums, int target) {
        n = nums.length;
        t = new int[n][target + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(t[i], -1);
        }

        return solve(0, nums, target);
    }
}
