public class UglyNum {
	public static void main(String[] args) {
		int num = 14;
		System.out.print(isUgly(num) + "\n");
	}

	public static boolean isUgly(int num) {
		if (num < 1) {
			return false;
		}		
		while (num % 2 == 0) {
			num = num/2;
		}
		while (num % 3 == 0) {
			num = num/3;
		}
		while (num % 5 == 0) {
			num = num/5;
		}
		if (num == 1) {
			return true;
		}
		return false;
	}
}