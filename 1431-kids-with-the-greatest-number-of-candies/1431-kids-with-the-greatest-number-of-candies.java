class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int mx = Integer.MIN_VALUE;
        for(int cand : candies){
            mx = Math.max(mx , cand);
        }
        for(int cand :candies){
            res.add(extraCandies+cand>=mx);
        }
        return res;
    }
}