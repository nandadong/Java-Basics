public class ValidPerfectSquare {
	public static void main(String[] args) {
		int num = 121;
		System.out.println(isPerfectSquare(num));
	}
	public static boolean isPerfectSquare(int num) {
		if (num == 0) return true;
		for (int i = 1; i <= num; i ++) {
			if (num / i > i) continue;
			if (num / i == i) return num % i == 0;
			if (num / i < i) break;
		}
		return false;
	}
}