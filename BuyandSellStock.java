public class BuyandSellStock {
	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		System.out.print(maxProfit(prices) + "\n");
	}

	public static int maxProfit(int[] prices) {
		int min = 0;
		int max = 0;
		int i = 0;
		for (; i < prices.length - 1; i++) {
			if (prices[i] < prices[i+1]) {
				min = prices[i];
				max = prices[i+1];
				break;
			}
		}
		if (max - min == 0) {
			return 0;
		}
		int mintemp = min;
		for (; i < prices.length; i++) {
			if (prices[i] > max) {
				max = prices[i];
			}
			if (prices[i] < min) {
				mintemp = prices[i];
			}
			if (prices[i] - mintemp > max - min) {
				min = mintemp;
				max = prices[i];
			}

		}
		return max - min;
	}
}