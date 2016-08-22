import java.util.*;
public class UniqueBST {
	public static void main(String[] args) {
		int n = 4;
		System.out.println(numTrees(n));
	}
	public static int numTrees(int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();	
		return numTreesHelper(n, map);
	}
	private static int numTreesHelper(int n, Map<Integer, Integer> map) {
		if (map.containsKey(n)) {
			return map.get(n);
		}
		if (n == 0 || n == 1) {
			return 1;
		}
		int result = 0;
		for (int i = 0; i < n; i ++) {
			result += numTreesHelper(i, map) * numTreesHelper(n - i - 1, map);
		}
		map.put(n, result);
		return result;
	}
}