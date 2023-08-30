class Solution {
     public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        map.put(sum, 1);

        for (int num : nums) {
            sum += num;
            int find = sum - k;
            if (map.containsKey(find)) {
                ans += map.get(find);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}