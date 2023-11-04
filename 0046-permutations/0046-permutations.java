class Solution {
    public void solve(int nums[] , List<List<Integer>> res , List<Integer> temp){
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(temp.contains(nums[i])){
                continue;
            }else{
                temp.add(nums[i]);
                solve(nums , res , temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(nums ,  res , temp);
        return res;
    }
}