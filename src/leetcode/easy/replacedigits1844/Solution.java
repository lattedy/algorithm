package leetcode.easy.replacedigits1844;

public class Solution {
	public String replaceDigits(String s) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < s.length(); i++) {
			if ((i & 0x1) == 0) sb.append(s.charAt(i));
			else sb.append((char)(s.charAt(i-1) + (s.charAt(i)-'0')));
		}

		return sb.toString();
	}
}
