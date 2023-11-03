class Solution {
    public void solve(int arr , int target , int indx , List<List<Integer>> res , List<Integer> temp){
        if(target == 0 &&  temp.size()==arr){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=indx;i<=9;i++){
            if(target-i>=0){
                temp.add(i);
                solve(arr , target-i , i+1 , res , temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum3(int arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(arr , target , 1 , res , temp);
        return res;
    }
}