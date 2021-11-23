package leetcode.hard.LargestComponentSizebyCommonFactor952;

public class Solution {
	int[] p;
	int[] cnt;
	int find(int x) {
		if (x == p[x]) return x;
		return p[x] = find(p[x]);
	}

	void union (int x, int y) {
		int px = find(x);
		int py = find(y);

		if (px == py) return;

		p[px] = py;
	}

	public int largestComponentSize(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
		}

		p = new int[max+1];
		cnt = new int[max+1];

		for (int i = 1; i < p.length; i++) {
			p[i] = i;
		}

		for (int num : nums) {
			for (int i = 2; i <= (int)Math.sqrt(num); i++) {
				if (num % i == 0) {
					union(num, i);
					int q = num / i;
					if (q > 1) union(num, q);
				}
			}
		}
		int ans = 0;
		for (int num : nums) {
			ans = Math.max(ans, ++cnt[find(num)]);
		}

		return ans;
	}
}
