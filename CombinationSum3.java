import java.util.*;
public class CombinationSum3 {
	public static void main(String[] args) {
		int k = 2, n = 18;
		System.out.println(combinationSum3(k, n));
	}
	private static int[] set = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	private static List<List<Integer>> list = new ArrayList<List<Integer>>();
	public static List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> init = new ArrayList<Integer>();
        combinationSum3Helper(k, n, 0, init);
        return list;
    }
    private static void combinationSum3Helper(int k, int n, int index, List<Integer> current) {
    	if (k == 0 && n == 0) {
    		list.add(current);
    		return;
    	} else if (k == 0 || n < 0) {
    		return;
    	}
    	for (int i = index; i < Math.min(set.length, n / k); i ++) {
    		List<Integer> l = new ArrayList<Integer>(current);
    		l.add(set[i]);
    		combinationSum3Helper(k - 1, n - set[i], i + 1, l);
    	}
    }
}