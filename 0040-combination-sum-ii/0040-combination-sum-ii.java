// class Solution {
//     public void solve(int [] arr , int target , List<List<Integer>> res , List<Integer> temp){
//         if(target == 0){
//             res.add(new ArrayList<>(temp));
//             return;
//         }
//         for(int i=0;i<arr.length;i++){
//             if(target-arr[i]>=0){
//                 temp.add(arr[i]);
//                 solve(arr , target , res , temp);
//                 temp.remove(temp.size()-1);
//             }
//         }
//     }
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//         List<List<Integer>> res = new ArrayList<>();
//         List<Integer> temp = new ArrayList<>();
//         solve(candidates , target , res , temp);
//         return res;
//     }
// }


class Solution {
    public void solve(int[] arr, int target, List<List<Integer>> res, List<Integer> temp, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            // Skip duplicates to avoid duplicate combinations
            if (i > start && arr[i] == arr[i - 1]) {
                continue;
            }

            if (target - arr[i] >= 0) {
                temp.add(arr[i]);
                solve(arr, target - arr[i], res, temp, i + 1); // Use the next index to avoid reusing the same element
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates); // Sort the input array to handle duplicates
        solve(candidates, target, res, temp, 0);
        return res;
    }
}
