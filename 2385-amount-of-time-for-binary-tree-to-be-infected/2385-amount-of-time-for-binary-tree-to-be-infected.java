class Solution {
    public void traverse(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            map.put(root.left, root);
        }
        if (root.right != null) {
            map.put(root.right, root);
        }
        traverse(root.left, map);
        traverse(root.right, map);
    }

     public TreeNode find(TreeNode root , int target){
        if(root == null){
            return null;
        }
        if(root.val == target){
            return root;
        }
        TreeNode findInLeft = find(root.left , target);
        if(findInLeft != null){
            return findInLeft;
        }
        TreeNode findInRigt = find(root.right , target);
        if(findInRigt != null){
            return findInRigt;
        }
        return null;
    }

    public int amountOfTime(TreeNode root, int start) {
        if (root == null) {
            return 0;
        }

        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        traverse(root, map);

        TreeNode source = find(root, start);
        if (source == null) {
            return 0;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        HashSet<TreeNode> visited = new HashSet<>();
        q.add(source);
        visited.add(source);
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode rnode = q.remove();
                if (rnode.left != null && !visited.contains(rnode.left)) {
                    q.add(rnode.left);
                    visited.add(rnode.left);
                }
                if (rnode.right != null && !visited.contains(rnode.right)) {
                    q.add(rnode.right);
                    visited.add(rnode.right);
                }
                if (map.containsKey(rnode) && !visited.contains(map.get(rnode))) {
                    visited.add(map.get(rnode));
                    q.add(map.get(rnode));
                }
            }
            time++;
        }

        if(time ==0){
            return 0;
        }
        return time-1;
    }
}
