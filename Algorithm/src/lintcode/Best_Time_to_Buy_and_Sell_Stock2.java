package lintcode;

public class Best_Time_to_Buy_and_Sell_Stock2 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}

		int sum = 0;
		int minBuy = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minBuy) {
				minBuy = prices[i];
			}
			if (prices[i] - minBuy > 0) {
				sum += prices[i] - minBuy;
				minBuy = prices[i];
			}
		}
		return sum;
	}
}
