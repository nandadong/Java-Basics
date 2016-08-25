public class FindMin {
	public static void main(String[] args) {
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		System.out.println(findMin(nums));
	}
	public static int findMin(int[] nums) {
		for (int i = 1; i < nums.length; i ++) {
			if (nums[i] < nums[i - 1]) {
				return nums[i];
			}
		}
		return nums[0];
	}
}