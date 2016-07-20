public class Palindrome {
	public static void main(String[] args) {
		int x = 123321;
		System.out.print(isPalindrome(x) + "\n");
	}
	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int t = x;
		int res = 0;
		while (t > 0) {
			res = res * 10 + t % 10;
			t = t / 10;
		}
		return res == x;
	}
}