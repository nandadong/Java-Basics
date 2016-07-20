public class FactorialTrailingZeroes {
	public static void main(String[] args) {
		int n = 30;
		System.out.print(trailingZeroes(n) + "\n");
	}
	public static int trailingZeroes(int n) {
		int num = 0;
		while (n / 5 != 0) {
			num += n / 5;
			n = n / 5;
		}
		return num;
	}
}