public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] nums = {10, 9, 2, 5, 3, 4};
		System.out.println(lengthOfLIS(nums));
	}
	public static int lengthOfLIS(int[] nums) {
		if (nums.length == 0 || nums == null) return 0;
		int max = Integer.MIN_VALUE;
		int[] dp = new int[nums.length];
		for (int i = 0; i < nums.length; i ++) {
			dp[i] = 1;
			for (int j = 0; j < i; j ++) {
				if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
			if (dp[i] > max) max = dp[i];
		}
		return max;
	}
}