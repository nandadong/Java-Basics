import java.util.*;
public class Isomorphic {
	public static void main(String[] args) {
		String s = "paper";
		String t = "title";
		System.out.print(isIsomorphic(s, t) + "\n");
	}
	public static boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == null && map.containsValue(t.charAt(i))) {
				return false;
			}
			if (map.get(s.charAt(i)) != null && map.get(s.charAt(i)) != t.charAt(i)) {
				return false;
			}
			map.put(s.charAt(i), t.charAt(i));
		}
		return true;
	}
}