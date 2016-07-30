public class ImplementstrStr {
	public static void main(String[] args) {
		String haystack = "leetcode", needle = "code";
		System.out.print(strStr(haystack, needle) + "\n");
	}
	public static int strStr(String haystack, String needle) {
		if (haystack.length() < needle.length()) {
			return -1;
		}
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			if (needle.equals(haystack.substring(i, i + needle.length()))) {
				return i;
			}
		}
		return -1;
	}
}