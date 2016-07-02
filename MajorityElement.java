import java.util.*;

public class MajorityElement {
	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 3, 5, 2, 2, 3, 3, 3, 3, 3, 3};
		System.out.print(majorityElement(nums) + "\n");
	}
	public static int majorityElement(int[] nums) {
		int n = nums.length;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i])+1);
			} else {
				map.put(nums[i], 1);
			}

			if (map.get(nums[i]) > Math.floor(n/2)) {
				return nums[i];
			}
		}
		return 0;
	}
}