import java.util.*;
public class Combinations {
	public static void main(String[] args) {
		int n = 4, k = 0;
		System.out.println(combine(n, k));
	}
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combination = new ArrayList<List<Integer>>();
		List<Integer> current = new ArrayList<Integer>();
		combineHelper(n, k, 1, combination, current);
		return combination;
	}
	private static void combineHelper(int n, int k, int index, List<List<Integer>> combination, List<Integer> current) {
		if (k == 0) {
			combination.add(current);
			return;
		}
		for (int i = index; i <= n - k + 1; i ++) {
			List<Integer> newCurrent = new ArrayList<Integer>(current);
			newCurrent.add(i);
			combineHelper(n, k - 1, i + 1, combination, newCurrent);
		}
	}
}