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
    public void inOrder(TreeNode root , ArrayList<Integer> in){
        if(root == null){
            return;
        }
        inOrder(root.left , in);
        if(root.left == null && root.right == null){
            in.add(root.val);
        }
        inOrder(root.right , in);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> root1Data = new ArrayList<>();
        ArrayList<Integer> root2Data = new ArrayList<>();
        inOrder(root1 , root1Data);
        inOrder(root2 , root2Data);
        if(root1Data.size() != root2Data.size()){
            return false;
        }
        for(int i=0;i<root1Data.size();i++){
            if(root1Data.get(i) != root2Data.get(i)){
                return false;
            }
        }
        return true;
    }
}