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
    public void helper(TreeNode root , int targetSum , List<List<Integer>> res , List<Integer> smaRes){
        if(root==null){
            return;
        }
        targetSum -= root.val;
        if(root.left == null && root.right == null && targetSum ==0){
            List<Integer> base = new ArrayList<>(smaRes);
            base.add(root.val);
            res.add(base);
            return;
        }
        smaRes.add(root.val);
        helper(root.left , targetSum , res , smaRes);
        helper(root.right , targetSum , res , smaRes);
        smaRes.remove(smaRes.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res =new ArrayList<>();
        List<Integer> smaRes = new ArrayList<>();
        helper(root , targetSum , res , smaRes);
        return res;
    }
}