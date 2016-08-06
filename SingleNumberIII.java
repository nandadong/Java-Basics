import java.util.*;
public class SingleNumberIII {
	public static void main(String[] args) {
		int[] nums = {1, 2, 1, 3, 2, 5};
		int[] result = singleNumber(nums);
		for (int element : result) {
			System.out.print(element + ", ");
		}
		System.out.print("\n");
	}
	// public static int[] singleNumber(int[] nums) {
	// 	int[] result = new int[2];
	// 	HashSet<Integer> set = new HashSet<Integer>();
	// 	for (int num : nums) {
	// 		if (!set.contains(num)) set.add(num);
	// 		else set.remove(num);
	// 	}
	// 	Iterator itr = set.iterator();
	// 	result[0] = (int) itr.next();
	// 	result[1] = (int) itr.next();
	// 	return result;
	// }
	public static int[] singleNumber(int[] nums) {
		int diff = 0;
		for (int num : nums) diff ^= num;
		diff &= -diff;	//get rightmost set bit
		int[] result = {0, 0};
		for (int num : nums) {
			if ((diff & num) == 0) result[0] ^= num;
			else result[1] ^= num;
		}
		return result;
	}
}