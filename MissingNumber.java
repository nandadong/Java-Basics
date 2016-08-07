public class MissingNumber {
	public static void main(String[] args) {
		int[] nums = {1};
		System.out.println(missingNumber(nums));
	}
	public static int missingNumber(int[] nums) {
		int expSum = 0, realSum = 0;
		for (int i = 0; i < nums.length; i++) {
			realSum += nums[i];
			expSum += i + 1;
		}
		return expSum - realSum;
	}
}