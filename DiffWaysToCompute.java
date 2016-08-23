import java.util.*;
public class DiffWaysToCompute {
	public static void main(String[] args) {
		String input = "2*3-4*5";
		System.out.println(diffWaysToCompute(input));
	}
	private static Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
	public static List<Integer> diffWaysToCompute(String input) {
		if (map.containsKey(input)) {
			return map.get(input);
		}
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); i ++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				List<Integer> subResults1 = diffWaysToCompute(input.substring(0, i));
				List<Integer> subResults2 = diffWaysToCompute(input.substring(i + 1));
				for (int a : subResults1) {
					for (int b : subResults2) {
						switch (c) {
							case '+': result.add(a + b); break;
							case '-': result.add(a - b); break;
							case '*': result.add(a * b); break;
							default: break;
						}
					}
				}
			}
		}
		if (result.isEmpty()) {
			result.add(Integer.valueOf(input));
		}
		map.put(input, result);
		return result;
	}
}