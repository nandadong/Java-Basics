public class BuyandSellStockCooldown {
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 0, 2};
		System.out.println(maxProfit(prices));
	}
	public static int maxProfit(int[] prices) {
		/*** Greedy works ***/
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int buy0 = -prices[0], buy1 = buy0, sell0 = 0, sell1 = 0, sell2 = 0;
		for (int i = 1; i < prices.length; i ++) {
			sell0 = Math.max(sell1, buy1 + prices[i]);
			buy0 = Math.max(buy1, sell2 - prices[i]);
			sell2 = sell1;
			sell1 = sell0;
			buy1 = buy0;
		}
		return sell0;
	}
}