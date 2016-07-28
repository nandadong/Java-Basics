import java.util.*;
public class WordPattern {
	public static void main(String[] args) {
		String pattern = "abba", str = "dog dog dog dog";
		System.out.print(wordPattern(pattern, str) + "\n");
	}
	public static boolean wordPattern(String pattern, String str) {
		String[] strarr = str.split(" ");
		if (pattern.length() != strarr.length) {
			return false;
		}
		HashMap<Character, String> map = new HashMap<Character, String>();
		for (int i = 0; i < pattern.length(); i++) {
			if (map.get(pattern.charAt(i)) == null) {
				if (map.containsValue(strarr[i])) {
					return false;
				}
				map.put(pattern.charAt(i), strarr[i]);
			} else if (!map.get(pattern.charAt(i)).equals(strarr[i])) {
				return false;
			}
		}
		return true;
	}
}