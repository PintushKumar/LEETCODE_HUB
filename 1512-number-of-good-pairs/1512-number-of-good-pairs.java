class Solution {
    public int numIdenticalPairs(int[] nums) {
        int countPair = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int ele :nums){
            if(map.containsKey(ele)){
                countPair += map.get(ele);
            }
            map.put(ele , map.getOrDefault(ele , 0 )+1);
        }
        return countPair;
    }
}