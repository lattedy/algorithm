package leetcode.easy.palindromenumber9;

public class Solution {
	public boolean isPalindrome(int x) {
		String str = String.valueOf(x);
		if (str.charAt(0) == '-') return false;

		int len = str.length();
		int half = len >> 1;
		for (int i = 0; i <= half; i++) {
			if (str.charAt(i) != str.charAt(len-i-1)) return false;
		}

		return true;
	}
}
