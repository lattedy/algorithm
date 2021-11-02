package leetcode.easy.SumOfLeftLeaves404;

public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public int getSum(TreeNode now, boolean isLeft) {
		int ret = 0;
		if (isLeft && now.right == null && now.left == null) return now. val;
		if (now.right != null) ret += getSum(now.right, false);
		if (now.left != null) ret += getSum(now.left, true);

		return ret;
	}

	public int sumOfLeftLeaves(TreeNode root) {
		return root == null ? 0 : getSum(root, false);
	}
}
