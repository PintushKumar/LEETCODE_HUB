class Solution {
    public void solve(int [] arr , int target , int start , List<List<Integer>> res , List<Integer> temp){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<arr.length;i++){
            if(i>start && arr[i]==arr[i-1]){
                continue;
            }
            if(target-arr[i]>=0){
                temp.add(arr[i]);
                solve(arr , target-arr[i] , i+1 ,res , temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates , target , 0 ,  res , temp);
        return res;
    }
}


