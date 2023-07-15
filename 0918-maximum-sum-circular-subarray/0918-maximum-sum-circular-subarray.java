class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxiSubArr = Integer.MIN_VALUE;
        int tempMax=0;
        
        int miniSubArr = Integer.MAX_VALUE;
        int tempMin = 0;
        
        int totalSum =0;
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
            // maxi
            int curr = nums[i];
            int prev = tempMax+nums[i];
            tempMax = Math.max(curr , prev);
            maxiSubArr = Math.max(maxiSubArr , tempMax);
            
            // mini 
            int currmin = nums[i];
            int prevmin = tempMin+nums[i];
            tempMin = Math.min(currmin , prevmin);
            miniSubArr = Math.min(miniSubArr , tempMin);
        }
        if(maxiSubArr<0){
            return maxiSubArr;
        }
        int wrapAround = totalSum -miniSubArr;
        return Math.max(maxiSubArr , wrapAround);
    }
}