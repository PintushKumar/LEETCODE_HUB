class Solution {
    public int reverse(int n ){
        int rev =0;
        while(n!=0){
            rev = ((rev*10)+(n%10));
            n/=10;
        }
        return rev;
    }
    public int countNicePairs(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int mod = 1000000007;
        int count =0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]-reverse(nums[i]))){
                count = (count + map.get(nums[i]-reverse(nums[i])))%mod;
            }
            map.put(nums[i]-reverse(nums[i]) , map.getOrDefault(nums[i]-reverse(nums[i]),0)+1);
        }
        return count;
    }
}