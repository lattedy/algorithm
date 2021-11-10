package leetcode.medium.TimeToBuySellStock714;

public class Solution1 {
	public int maxProfit(int[] prices, int fee) {
		int yes = -(prices[0]+fee);
		int no = 0;
		for (int i = 1; i < prices.length; i++) {
			yes = Math.max(yes, no-prices[i]-fee);
			no = Math.max(no, yes+prices[i]);
		}
		return no;
	}
}
