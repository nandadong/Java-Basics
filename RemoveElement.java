import java.util.Arrays;
public class RemoveElement {
	public static void main(String[] args) {
		int[] nums = {3, 2, 2, 3};
		int val = 3;
		System.out.print(removeElement(nums, val) + "\n");
		for (int element : nums) {
			System.out.print(element + " ");
		}
		System.out.print("\n");
	}
	public static int removeElement(int[] nums, int val) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {
				nums[i] = Integer.MAX_VALUE;
				count ++;
			}
		}
		Arrays.sort(nums);
		return nums.length - count;
	}
}