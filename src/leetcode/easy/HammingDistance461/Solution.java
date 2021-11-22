package leetcode.easy.HammingDistance461;

public class Solution {
	public int hammingDistance(int x, int y) {
		int ans = 0;
		for (int i = 0; i < 31; i++) {
			int a = (x>>i) & 0x1;
			int b = (y>>i) & 0x1;
			if (a != b) ans++;
		}

		return ans;
	}
}
