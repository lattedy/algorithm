package leetcode.easy.ReplaceDigits1844;

public class Solution2 {
	public String replaceDigits(String s) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 1; i < s.length(); i+=2) {
			sb.append(s.charAt(i-1));
			sb.append((char)(s.charAt(i-1) + (s.charAt(i)-'0')));
		}

		if ((s.length() & 0x1) == 1) sb.append(s.charAt(s.length()-1));
		return sb.toString();
	}
}
