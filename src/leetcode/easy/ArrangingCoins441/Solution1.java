package leetcode.easy.ArrangingCoins441;

public class Solution1 {
	long getSum(long x) {
		return (x * (x+1)) >> 1;
	}

	long parametric(long l, long r, int n) {
		while (l <= r) {
			long m = (l + r) >> 1;
			long sum1 = getSum(m-1);
			long sum2 = getSum(m);

			if (n < sum1) r = m-1;
			else if (n > sum2) l = m+1;
			else if (n >= sum1 && n < sum2) return m-1;
			else if (n == sum2) return m;
		}

		return -1;
	}

	public int arrangeCoins(int n) {
		long l = 1;
		long r = 65536;

		return (int)parametric(l, r, n);
	}
}
