class Solution {
    public long countSubarrays(int[] nums, long k) {
        long count =0;
        int n = nums.length;
        long sum =0;
        int l =0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            while(sum*(i-l+1)>=k){
                sum-=nums[l];
                l++;
            }
            count+=(i-l+1);
        }
        return count;
    }
}