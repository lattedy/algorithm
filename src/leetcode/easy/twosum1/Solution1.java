package leetcode.easy.twosum1;

public class Solution1 {
	public int[] twoSum(int[] nums, int target) {
		int N = nums.length;
		int[] ans = {0,0};
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				if (nums[i] + nums[j] == target) {
					ans[0] = i;
					ans[1] = j;
					break;
				}
			}
			if (ans[1] != 0) break;
		}

		return ans;
	}
}
