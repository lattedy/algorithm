package leetcode.medium.TimeToBuySellStockII122;

public class Solution {
	public int maxProfit(int[] prices) {
		int yes = -prices[0], no = 0;
		for (int i = 1; i < prices.length; i++) {
			yes = Math.max(yes, no-prices[i]);
			no = Math.max(no, prices[i]+yes);
		}
		return no;
	}
}
