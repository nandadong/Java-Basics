import java.util.*;
public class TwoSum2 {
	public static void main(String[] args) {
		int[] numbers = {2, 7, 11, 15};
		int target = 13;
		int[] result = twoSum(numbers, target);
		for (int res : result) System.out.print(res + " ");
		System.out.print("\n");
	}
	public static int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		int start = 0, end = numbers.length - 1;
		while (start < end) {
			int val = numbers[start] + numbers[end];
			if (val == target) {
				result[0] = start + 1;
				result[1] = end + 1;
				break;
			} else if (val < target) {
				start ++;
			} else {
				end --;
			}
		}
		return result;
	}
}