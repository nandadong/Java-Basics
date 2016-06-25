import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class TwoSum {
	public static void main(String[] args) {
		int[] nums = {3, 2, 4};
		int target = 6;
		int[] result = twoSum(nums, target);
		System.out.print("[" + result[0] + ", " + result[1] + "] \n");

	}
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(map.get(nums[i]) != null) {
				int[] result = {map.get(nums[i]), i};
				return result;
			}
			map.put(target - nums[i], i);
		}
		int[] result = {};
		return result;
	}
}
