package leetcode.medium.AllElementsInTwoBinaryTree1305;

import java.util.*;

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

	public PriorityQueue<Integer> pq = new PriorityQueue<>();
	public void putPQ(TreeNode now) {
		pq.add(now.val);
		if (now.left != null) putPQ(now.left);
		if (now.right != null) putPQ(now.right);
	}
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		if (root1 != null) putPQ(root1);
		if (root2 != null) putPQ(root2);

		ArrayList<Integer> ans = new ArrayList<>();
		while (!pq.isEmpty()) {
			ans.add(pq.poll());
		}

		return ans;
	}
}
