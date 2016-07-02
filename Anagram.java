import java.util.Arrays;

public class Anagram {
	public static void main(String[] args) {
		String s = "rat";
		String t = "car";
		System.out.print(isAnagram(s,t) + "\n");

	}
	public static boolean isAnagram(String s, String t) {
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		Arrays.sort(sc);
		Arrays.sort(tc);
		String scs = new String(sc);
		String tcs = new String(tc);
		if (scs.equals(tcs)) {
			return true;
		}
		return false;
	}
}