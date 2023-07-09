class Solution {
    public int[] shuffle(int[] nums, int n) {
        int res[] = new int[2*n];
        int residx =0;
        for(int i=0;i<n;i++){
            res[residx++]=nums[i];
            res[residx++]=nums[n+i];
        }
        return res;
    }
}