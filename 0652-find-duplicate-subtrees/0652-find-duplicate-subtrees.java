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
    String helper(TreeNode root , HashMap<String , Integer> map , List<TreeNode> res){
        if(root == null ){
            return "N";
        }
        StringBuilder s = new StringBuilder();
        s.append(root.val);
        s.append(",");
        s.append(helper(root.left , map , res));
        s.append(",");
        s.append(helper(root.right , map , res));
        s.append("'");
        if(map.containsKey(s.toString()) && map.get(s.toString())==1){
            res.add(root);
        }

        map.put(s.toString() , map.getOrDefault(s.toString() , 0)+1);

        return s.toString();
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        HashMap<String , Integer > map = new HashMap<>();
        helper(root , map , res);
        return res;
    }
}