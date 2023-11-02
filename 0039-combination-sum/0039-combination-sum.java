
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    public void solve(int arr[], int target, int indx, List<List<Integer>> res, List<Integer> temp) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = indx; i < arr.length; i++) {
            if (target - arr[i] >= 0) {
                temp.add(arr[i]);
                solve(arr, target - arr[i], i, res, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solve(candidates, target, 0, res, temp);
        return res;
    }
}
