import java.util.*;
public class GenerateParentheses {
	public static void main(String[] args) {
		int n = 2;
		System.out.println(generateParentheses(n));
	}
	public static List<String> generateParentheses(int n) {
		List<String> list = new ArrayList<String>();
		if (n == 0) return list;
		int num = 1;
		generateParenthesesHelper("(", n, num, list);
		return list;
	}
	private static void generateParenthesesHelper(String s, int n, int num, List<String> list) {
		if (n == 0) {
			list.add(s);
			return;
		}
		if (num < n) {
			generateParenthesesHelper(s + "(", n, num + 1, list);
		}
		if (num > 0) {
			generateParenthesesHelper(s + ")", n - 1, num - 1, list);
		}
	}
}