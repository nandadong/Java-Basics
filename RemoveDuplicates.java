public class RemoveDuplicates {
	public static void main(String[] args) {
		int[] nums = {1, 1, 2, 2, 3, 4, 5};
		System.out.print(removeDuplicates(nums) + "\n");
		for (int element : nums) {
			System.out.print(element + " ");
		}
		System.out.print("\n");
	}
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}
}