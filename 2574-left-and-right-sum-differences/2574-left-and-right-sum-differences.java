class Solution {
    public int[] leftRightDifference(int[] nums) {
       int n = nums.length;
       int [] lsum = new int[n];
       int rsum[] = new int[n];
       int res[] = new int[n];
        int pre =0;
        for(int i=0;i<n;i++){
            lsum[i]=pre;
            pre+=nums[i];
        }
        pre=0;
        for(int i=n-1;i>=0;i--){
            rsum[i]=pre;
            pre+=nums[i];
        }
        for(int i=0;i<n;i++){
            res[i]=Math.abs(lsum[i]-rsum[i]);
        }
        return res;
    }
}