/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void merge(List<Integer> finalRes ,ArrayList<Integer> r1 , ArrayList<Integer> r2 ){
        int n = r1.size();
        int m = r2.size();
        int ir1 =0;
        int ir2 = 0;
        while(ir1<n && ir2<m){
            if(r1.get(ir1)<=r2.get(ir2)){
                finalRes.add(r1.get(ir1));
                ir1++;
            }else{
                finalRes.add(r2.get(ir2));
                ir2++;
            }
        }
        while(ir1<n){
            finalRes.add(r1.get(ir1));
            ir1++;
        }
        while(ir2<m){
            finalRes.add(r2.get(ir2));
            ir2++;
        }
    }
    public void inOrder(TreeNode root , ArrayList<Integer> in){
        if(root == null){
            return;
        }
        inOrder(root.left , in);
        in.add(root.val);
        inOrder(root.right , in);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> r1 = new ArrayList<>();
        inOrder(root1 , r1);
        ArrayList<Integer> r2 = new ArrayList<>();
        inOrder(root2 , r2);
        
        List<Integer> finalRes = new ArrayList<>();
        merge(finalRes , r1 , r2);
        return finalRes;
    }
}