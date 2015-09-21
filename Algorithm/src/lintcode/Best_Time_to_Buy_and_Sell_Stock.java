package lintcode;

public class Best_Time_to_Buy_and_Sell_Stock {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}

		int minBuy = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minBuy) {
				minBuy = prices[i];
			}
			maxProfit = Math.max(maxProfit, prices[i] - minBuy);
		}
		return maxProfit;
	}
}
