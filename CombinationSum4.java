import java.util.*;
public class CombinationSum4 {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		int target = 32;
		System.out.println(combinationSum4(nums, target));
	}
	private static int[] targets;
	public static int combinationSum4(int[] nums, int target) {
		targets = new int[target + 1];
		Arrays.fill(targets, -1);
		targets[0] = 1;
		return combinationSum4Helper(nums, target);
	}
	private static int combinationSum4Helper(int[] nums, int target) {
		if (targets[target] != -1) return targets[target];
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (target - nums[i] >= 0) result += combinationSum4Helper(nums, target - nums[i]);
		}
		targets[target] = result;
		return result;
	}
}