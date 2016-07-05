public class ClimbStairs {
	public static void main(String[] args) {
		int n = 5;
		System.out.print(climbStairs(n) + "\n");
	}
	public static int climbStairs(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		int f1 = 1;
		int f2 = 1;
		int result = -1;
		for (int i = 2; i <= n; i++) {
			result = f1 + f2;
			f2 = f1;
			f1 = result;
		}
		return result;

	}
}