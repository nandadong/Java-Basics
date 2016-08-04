public class RotateArray {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		int k = 10;
		rotate(nums, k);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.print("\n");
	}
	public static void rotate(int[] nums, int k) {
		// int[] prev = new int[nums.length];
		// for (int i = 0; i < nums.length; i++) {
		// 	prev[i] = nums[i];
		// }
		// for (int i = 0; i < nums.length; i++) {
		// 	nums[(i + k) % nums.length] = prev[i];
		// }
		k = k % nums.length;
		reverse(nums, 0, nums.length - k - 1);
		reverse(nums, nums.length - k, nums.length - 1);
		reverse(nums, 0, nums.length - 1);
	}
	private static void reverse(int[] nums, int i, int j) {
		while (i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i ++;
			j --;
		}
	}
}