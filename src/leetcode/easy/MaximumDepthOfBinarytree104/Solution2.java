package leetcode.easy.MaximumDepthOfBinarytree104;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
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

	public class Node {
		TreeNode treeNode;
		int depth;

		public Node(TreeNode treeNode, int depth) {
			this.treeNode = treeNode;
			this.depth = depth;
		}
	}

	public int bfs(TreeNode root) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(root, 1));

		int ret = 1;
		while (!q.isEmpty()) {
			Node now = q.poll();
			ret = Math.max(ret, now.depth);
			if (now.treeNode.left != null) q.add(new Node(now.treeNode.left, now.depth+1));
			if (now.treeNode.right != null) q.add(new Node(now.treeNode.right, now.depth+1));
		}

		return ret;
	}

	public int maxDepth(TreeNode root) {
		return root==null ? 0 : bfs(root);
	}
}
