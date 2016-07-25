import java.util.*;
public class NearbyDuplicates {
	public static void main(String[] args) {
		int[] nums = {1, 2, 4, 5, 6, 7, 2};
		int k = 5;
		System.out.print(containsNearbyDuplicate(nums, k) + "\n");
	}
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(nums[i]) == null || i - map.get(nums[i]) > k) {
				map.put(nums[i], i);
			} else {
				return true;
			}
		}
		return false;
	}
}