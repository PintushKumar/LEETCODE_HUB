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
  int leftMostPos = 0;
	int rightMostPos = 0;
	
	void traversal(TreeNode root, int pos) {
		if (root == null) {
			return;
		}

		leftMostPos = Math.min(leftMostPos, pos);
		rightMostPos = Math.max(rightMostPos, pos);
		
		traversal(root.left, pos - 1);
		traversal(root.right, pos + 1);
	}

 class Pair implements Comparable<Pair> {
		TreeNode node;
		int vLevel;

		Pair (TreeNode node, int vLevel) {
			this.node = node;
			this.vLevel = vLevel;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.vLevel == o.vLevel) {
				return this.node.val - o.node.val;
			} else {
				return this.vLevel - o.vLevel;
			}
		}
	}
	
  List<List<Integer>> verticalTraversal(TreeNode root) {
    //Write your code here
		if (root == null) {
			return new ArrayList<>();
		}
		
		traversal(root, 0);

		int numberOfVLevel = rightMostPos - leftMostPos + 1;
		int vLevelOfRoot = -leftMostPos;

		List<List<Integer>> vo = new ArrayList<>();
		for (int i = 0; i < numberOfVLevel; i++) {
			vo.add(new ArrayList<>());
		}

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(root, vLevelOfRoot));

		while (pq.size() > 0) {
			int size = pq.size();

			PriorityQueue<Pair> cpq = new PriorityQueue<>();
			while (size-->0) {
				Pair rpair = pq.remove();

				vo.get(rpair.vLevel).add(rpair.node.val);

				if (rpair.node.left != null) {
					cpq.add(new Pair(rpair.node.left, rpair.vLevel - 1));
				}

				if (rpair.node.right != null) {
					cpq.add(new Pair(rpair.node.right, rpair.vLevel + 1));
				}
			}
     	pq = cpq;
		}
		return vo;
  }
}