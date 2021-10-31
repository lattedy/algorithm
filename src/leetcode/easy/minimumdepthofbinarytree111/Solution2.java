package leetcode.easy.minimumdepthofbinarytree111;

import java.util.*;

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

		while (!q.isEmpty()) {
			Node now = q.poll();
			if (now.treeNode.left == null && now.treeNode.right == null) return now.depth;

			if (now.treeNode.left != null) q.add(new Node(now.treeNode.left, now.depth+1));
			if (now.treeNode.right != null) q.add(new Node(now.treeNode.right, now.depth+1));
		}
		return -1;
	}

	public int minDepth(TreeNode root) {

		return root==null ? 0 : bfs(root);
	}
}
