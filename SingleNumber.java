import java.util.*;
public class SingleNumber {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 3, 2, 1};
		System.out.println(singleNumber(nums));
	}
	// public static int singleNumber(int[] nums) {
	// 	int x = 0, y = 0;
	// 	HashSet<Integer> set = new HashSet<Integer>();
	// 	for (int num : nums) {
	// 		x += num;
	// 		if (!set.contains(num)) {
	// 			set.add(num);
	// 			y += num;
	// 		}
	// 	}
	// 	return 2 * y - x;
	// }
	public static int singleNumber(int[] nums) {
		int result = 0;
		for (int num : nums) {
			result ^= num;
		}
		return result;
	}
}