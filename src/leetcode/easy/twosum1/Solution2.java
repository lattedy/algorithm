package leetcode.easy.twosum1;

import java.util.Arrays;

public class Solution2 {
	public Ele[] eles;
	public class Ele implements Comparable<Ele> {
		int num, idx;
		public Ele(){}
		public Ele(int num, int idx) {
			this.num = num;
			this.idx = idx;
		}

		@Override
		public int compareTo(Ele o) {
			return Integer.compare(this.num, o.num);
		}
	}

	public int bs(int l, int r, int v) {
		while (l <= r) {
			int mid = (l + r) >> 1;
			int n = eles[mid].num;

			if (n == v) return mid;
			else if (n < v) l = mid+1;
			else r = mid-1;
		}

		return -1;
	}

	public int[] twoSum(int[] nums, int target) {
		int N = nums.length;
		int[] ans = {0,0};

		eles = new Ele[N];
		for (int i = 0; i < N; i++) {
			eles[i] = new Ele(nums[i], i);
		}

		Arrays.sort(eles);

		for (int i = 0; i < N; i++) {
			int n = eles[i].num;
			int res = bs(i+1, N-1, target-n);
			if (res == -1) continue;
			ans[0] = eles[i].idx;
			ans[1] = eles[res].idx;
			break;
		}

		return ans;
	}
}