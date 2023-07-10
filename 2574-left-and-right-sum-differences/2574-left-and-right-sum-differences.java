class Solution {
    public int[] leftRightDifference(int[] nums) {
        
//*******************  My bruteForce Solution *************************
       // int n = nums.length;
       // int [] lsum = new int[n];
       // int rsum[] = new int[n];
       // int res[] = new int[n];
       //  int pre =0;
       //  for(int i=0;i<n;i++){
       //      lsum[i]=pre;
       //      pre+=nums[i];
       //  }
       //  pre=0;
       //  for(int i=n-1;i>=0;i--){
       //      rsum[i]=pre;
       //      pre+=nums[i];
       //  }
       //  for(int i=0;i<n;i++){
       //      res[i]=Math.abs(lsum[i]-rsum[i]);
       //  }
       //  return res;
        
// **********************************************************************
        
        int totalSum =0 , rightSum = 0 , leftSum =0 ;
        for(int ele: nums){
            totalSum+=ele;
        }
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            rightSum = totalSum - val;
            totalSum -= val;
            nums[i] = Math.abs(leftSum - rightSum);
            leftSum+=val;
        }
        return nums;
    }
}