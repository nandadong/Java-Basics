public class IntegerBreak {
	public static void main(String[] args) {
		int n = 11;
		System.out.println(integerBreak(n));
	}
	public static int integerBreak(int n) {
		if (n == 2) return 1;
		if (n == 3) return 2;
		int product = 1;
		while (n > 4) {
			product *= 3;
			n -= 3;
		}
		product *= n;
		return product;
	}
}