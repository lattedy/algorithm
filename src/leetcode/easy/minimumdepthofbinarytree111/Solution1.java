package leetcode.easy.minimumdepthofbinarytree111;

public class Solution1 {
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

	public int dfs(TreeNode now, int d) {
		if (now.left == null && now.right == null) return d;

		int ret = Integer.MAX_VALUE;
		if (now.left != null) ret = Math.min(ret, dfs(now.left, d+1));
		if (now.right != null) ret = Math.min(ret, dfs(now.right, d+1));

		return ret;
	}

	public int minDepth(TreeNode root) {

		return root==null? 0 : dfs(root, 1);
	}
}
