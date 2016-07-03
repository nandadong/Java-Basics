public class PowerOfThree {

	public static void main(String[] args) {
		int n = 19684;
		System.out.print(isPowerOfThree(n) + "\n");
		// System.out.print(1%3 + "\n");
	}

	public static boolean isPowerOfThree(int n) {
		if (n <= 0) {
			return false;
		}
		while (n % 3 == 0) {
			n = n/3;
		}
		if (n == 1) {
			return true;
		}
		return false;
	}

}