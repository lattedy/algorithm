package leetcode.easy.SearchInsertPosition35;

public class Solution {
	public int searchInsert(int[] nums, int target) {

		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int m = (left + right) >> 1;
			if (nums[m] == target) return m;
			else if (nums[m] > target) right = m-1;
			else left = m+1;
		}

		return left;
	}
}
