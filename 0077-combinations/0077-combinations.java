class Solution {
    public void solve(int n , int k , int indx , List<List<Integer>> res , List<Integer>temp){
        if(temp.size()==k){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=indx;i<=n;i++){
            temp.add(i);
            solve(n , k , i+1 , res , temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(n , k , 1 , res , temp);
        return res;
    }
}