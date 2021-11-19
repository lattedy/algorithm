package leetcode.easy.CheckifOneStringSwapCanMakeStringsEqual1790;

public class Solution {
	public boolean areAlmostEqual(String s1, String s2) {
		int[][] al = new int[26][2];
		int diffCnt = 0;
		for (int i = 0; i < s1.length(); i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			al[c1-'a'][0]++;
			al[c2-'a'][1]++;

			if (c1 != c2) diffCnt++;
		}

		if ((diffCnt&0x1) == 1 || diffCnt > 2) return false;
		for (int i = 0; i < 26; i++) {
			if (al[i][0] != al[i][1]) return false;
		}

		return true;
	}
}
