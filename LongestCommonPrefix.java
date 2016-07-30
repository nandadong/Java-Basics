public class LongestCommonPrefix {
	public static void main(String[] args) {
		String[] strs = {"aca", "cba"};
		System.out.print(longestCommonPrefix(strs) + "\n");
	}
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String common = strs[0];
		for (int i = 1; i < strs.length; i++) {
			common = commonPrefix(common, strs[i]);
		}
		return common;
	}
	public static String commonPrefix(String s1, String s2) {
		int length = Math.min(s1.length(), s2.length());
		String common = "";
		for (int i = 0; i < length; i++) {
			if (s1.charAt(i) == s2.charAt(i)) {
				common += s1.charAt(i);
			} else {
				break;
			}
		}
		return common;
	}
}