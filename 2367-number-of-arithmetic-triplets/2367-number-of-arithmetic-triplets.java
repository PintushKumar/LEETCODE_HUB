class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int cnt =0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num-diff) && set.contains(num-diff*2)){
                cnt++;
            }
            set.add(num);
        }
        return cnt;
    }
}