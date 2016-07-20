public class Palindrome {
	public static void main(String[] args) {
		int x = 1233421;
		System.out.print(isPalindrome(x) + "\n");
	}
	public static boolean isPalindrome(int x) {
		String s = String.valueOf(x);
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
}