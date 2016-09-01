public class CoinChange {
	public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChangeHelper(coins, amount, new int[amount]);
    }
    private int coinChangeHelper(int[] coins, int remain, int[] dp) {
        if (remain < 0) return -1;
        if (remain == 0) return 0;
        if (dp[remain - 1] != 0) return dp[remain - 1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i ++) {
            int result = coinChangeHelper(coins, remain - coins[i], dp);
            if (result >= 0 && result < min) min = result + 1;
        }
        dp[remain - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[remain - 1];
    }
}