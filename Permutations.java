import java.util.*;
public class Permutations {
	public static void main(String[] args) {
		int[] nums = {};
		System.out.println(permute(nums));
	}
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> bag = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i ++) {
			bag.add(nums[i]);
		}
		List<Integer> current = new ArrayList<Integer>();
		permuteHelper(list, bag, current);
		return list;
	}
	private static void permuteHelper(List<List<Integer>> list, List<Integer> bag, List<Integer> current) {
		if (bag.isEmpty()) {
			list.add(current);
			return;
		}
		for (int i = 0; i < bag.size(); i ++) {
			List<Integer> newCurrent = new ArrayList<Integer>(current);
			List<Integer> newBag = new ArrayList<Integer>(bag);
			newCurrent.add(bag.get(i));
			newBag.remove(i);
			permuteHelper(list, newBag, newCurrent);
		}
	}
}