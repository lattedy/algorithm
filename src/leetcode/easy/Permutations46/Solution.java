package leetcode.easy.Permutations46;

import java.util.*;

public class Solution {
	List<List<Integer>> ans;
	boolean[] visit;
	int[] one;
	void permu(int[] nums, int d) {
		if (d == nums.length) {
			List<Integer> tmp = new ArrayList<>();
			for (int i : one) {
				tmp.add(i);
			}
			ans.add(tmp);
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			one[d] = nums[i];
			permu(nums, d+1);
			one[d] = 0;
			visit[i] = false;
		}
	}

	public List<List<Integer>> permute(int[] nums) {
		ans = new ArrayList<>();
		visit = new boolean[nums.length];
		one = new int[nums.length];

		permu(nums, 0);

		return ans;
	}
}
