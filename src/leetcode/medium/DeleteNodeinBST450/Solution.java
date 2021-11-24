package leetcode.medium.DeleteNodeinBST450;

class Solution {
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
	public TreeNode[] findKey(TreeNode root, int key) {
		TreeNode[] ret = new TreeNode[2];
		ret[0] = null;
		ret[1] = null;

		if (root.val == key) {
			ret[0] = root;
			return ret;
		}

		while (true) {
			if (root.left != null && root.val > key) {
				if (root.left.val == key) {
					ret[0] = root.left;
					ret[1] = root;
					return ret;
				}
				root = root.left;
			}
			else if (root.right != null && root.val < key) {
				if (root.right.val == key) {
					ret[0] = root.right;
					ret[1] = root;
					return ret;
				}
				root = root.right;
			}
			else return ret;
		}
	}

	public TreeNode getRightLeafNode(TreeNode root) {
		while (root.right != null) {
			root = root.right;
		}
		return root;
	}

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) return root;

		TreeNode[] keyNode = findKey(root, key);

		if (keyNode[0] == null) return root;

		// 키가 리프노드이면 그냥 얘만 삭제 -> 부모 노드에서 null로 만들기
		if (keyNode[0].left == null && keyNode[0].right == null) {
			if (keyNode[1] == null) return null;
			if (keyNode[1].left == keyNode[0]) keyNode[1].left = null;
			else keyNode[1].right = null;
		}
		// 키에 왼쪽 오른쪽이 다 있다면 왼쪽의 오른쪽리프노드에 오른쪽 붙이고 키의 왼쪽 노드를 부모노드에 붙인다.
		else if (keyNode[0].left != null && keyNode[0].right != null) {
			TreeNode rightLeafFromLeft = getRightLeafNode(keyNode[0].left);
			rightLeafFromLeft.right = keyNode[0].right;
			if (keyNode[1] == null) return keyNode[0].left;
			if (keyNode[1].left == keyNode[0]) keyNode[1].left = keyNode[0].left;
			else keyNode[1].right = keyNode[0].left;
		}
		// 키에 왼쪽이나 오른쪽 한쪽만 있다면 그냥 걔를 부모노드에 붙인다
		else if (keyNode[0].left != null) {
			if (keyNode[1] == null) return keyNode[0].left;
			if (keyNode[1].left == keyNode[0]) keyNode[1].left = keyNode[0].left;
			else keyNode[1].right = keyNode[0].left;
		}
		else {
			if (keyNode[1] == null) return keyNode[0].right;
			if (keyNode[1].left == keyNode[0]) keyNode[1].left = keyNode[0].right;
			else keyNode[1].right = keyNode[0].right;
		}

		return root;
	}
}