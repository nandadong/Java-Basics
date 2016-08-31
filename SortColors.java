public class SortColors {
	public static void main(String[] args) {
		int[] nums = {0, 1, 2, 0, 1, 2};
		sortColors(nums);
		for (int num : nums) System.out.print(num + " ");
		System.out.print("\n");
	}
	public static void sortColors(int[] nums) {
		int i = -1, j = nums.length;
		for (int k = 0; k < nums.length; k ++) {
			if (nums[k] == 0) i ++;
			else if (nums[k] == 2) j --; 
		}
		for (int k = 0; k <= i; k ++) {
			nums[k] = 0;
		}
		for (int k = i + 1; k < j; k ++) {
			nums[k] = 1;
		}
		for (int k = j; k < nums.length; k ++) {
			nums[k] = 2;
		}
	}
}