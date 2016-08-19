public class SingleNumberII {
	public static void main(String[] args) {
		int[] nums = {2, 3, 3, 3};
		System.out.println(singleNumber(nums));
	}
	public static int singleNumber(int[] nums) {
		int result = 0;
		for (int i = 0; i < 32; i ++) {
			int sum = 0;
			for (int j = 0; j < nums.length; j ++) {
				if (((nums[j] >> i) & 1) == 1) sum ++;
			}
			sum %= 3;
			if (sum == 1) result |= (1 << i);
		}
		return result;
	}
}